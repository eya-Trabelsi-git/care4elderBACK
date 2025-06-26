package com.reclamation.reclamtion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reclamation.reclamtion.model.Reclamation;
import com.reclamation.reclamtion.service.ReclamationService;

@RestController
@RequestMapping("/api/reclamations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService;

    private static final String LLAMA_API_URL = "https://api.together.xyz/v1/chat/completions";
    private static final String LLAMA_API_KEY = "89b36e7bbea6d209cf24dd2a4eb27b074c636956648b39a7dda891cb7235814c";
    private static final String LLAMA_MODEL = "meta-llama/Llama-3.3-70B-Instruct-Turbo-Free";

    // GET all reclamations
    @GetMapping
    public ResponseEntity<List<Reclamation>> getAllReclamations() {
        List<Reclamation> reclamations = reclamationService.getAllReclamations();
        return new ResponseEntity<>(reclamations, HttpStatus.OK);
    }

    // GET a reclamation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reclamation> getReclamationById(@PathVariable Long id) {
        Reclamation reclamation = reclamationService.getReclamationById(id);
        if (reclamation != null) {
            return new ResponseEntity<>(reclamation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST a new reclamation
    @PostMapping
    public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation) {
        Reclamation createdReclamation = reclamationService.createReclamation(reclamation);
        return new ResponseEntity<>(createdReclamation, HttpStatus.CREATED);
    }

    // PUT to update a reclamation by ID
    @PutMapping("/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable Long id, @RequestBody Reclamation updatedReclamation) {
        Reclamation reclamation = reclamationService.updateReclamation(id, updatedReclamation);
        if (reclamation != null) {
            return new ResponseEntity<>(reclamation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE a reclamation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReclamation(@PathVariable Long id) {
        reclamationService.deleteReclamation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/reclamation")
    public ResponseEntity<ChatResponse> handleReclamation(@RequestBody ChatRequest request) {
        String prompt = String.format(
          "L'utilisateur a soumis la réclamation suivante : \"%s\"\n\n" +
        "Réponds comme un humain avec  un ton amical et naturel et phrase ne pas long . Propose exactement deux suggestions pour résoudre cette réclamation de manière efficace. " +
        "Concentre-toi uniquement sur des étapes ou recommandations actionnables liées à la résolution de la réclamation.\n\n" +
        "Retourne le résultat dans ce format :\n" +
        "Suggestions: <tes deux suggestions exprimées de façon conviviale>",
            request.getText()
        );

        String llamaResponse = fetchLlamaResponse(prompt);

        String suggestions = "[Could not extract suggestions]";
        if (llamaResponse.contains("Suggestions:")) {
            try {
                suggestions = llamaResponse.split("Suggestions:")[1].trim();
            } catch (Exception e) {
                suggestions = "[Parse error]";
            }
        }

        return ResponseEntity.ok(new ChatResponse(suggestions, ""));
    }

    private String fetchLlamaResponse(String prompt) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + LLAMA_API_KEY);

            ObjectMapper mapper = new ObjectMapper();
            ObjectNode message = mapper.createObjectNode();
            message.put("role", "user");
            message.put("content", prompt);

            ObjectNode requestBody = mapper.createObjectNode();
            requestBody.put("model", LLAMA_MODEL);
            requestBody.put("max_tokens", 512);
            requestBody.putArray("messages").add(message);

            HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);
            ResponseEntity<String> response = restTemplate.postForEntity(LLAMA_API_URL, entity, String.class);

            JsonNode root = mapper.readTree(response.getBody());
            return root.path("choices").get(0).path("message").path("content").asText();

        } catch (Exception e) {
            System.err.println("Error calling LLaMA API: " + e.getMessage());
            return "[Suggestions failed]";
        }
    }
    @PostMapping("/reclamation/dection-urgence")
public ResponseEntity<ChatResponse> dectionurgence(@RequestBody ChatRequest request) {
    String prompt = String.format(
        "L'utilisateur a soumis la réclamation suivante : \"%s\"\n\n" +
        "Analyse la réclamation et réponds avec un seul mot : 'urgent' si la réclamation est urgente, sinon 'non-urgent'. " +
        "Considère une réclamation comme urgente si elle mentionne des mots comme 'urgence', 'immédiat', 'critique', 'danger', ou des délais explicites (par exemple, 'aujourd'hui', 'maintenant').",
        request.getText()
    );

    String llamaResponse = fetchLlamaResponse(prompt);

    String urgency = "non-urgent"; 
    if (llamaResponse.trim().equalsIgnoreCase("urgent")) {
        urgency = "urgent";
    }

    return ResponseEntity.ok(new ChatResponse(urgency, ""));
}
}