import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReclamationService } from '../services/reclamation.service';
import { Reclamation } from '../models/Reclamation';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-reclamation',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-reclamation.component.html',
  styleUrls: ['./add-reclamation.component.css']
})
export class AddReclamationComponent {
  reclamation: Reclamation = {
    titre: '',
    description: '',
    UserId: 1,
    dateCreation: this.getCurrentDateTime(),
    etat: 'EN_ATTENTE'
  };

  constructor(
    private reclamationService: ReclamationService,
    private router: Router
  ) {}

  private getCurrentDateTime(): string {
    const now = new Date();
    return now.toISOString().slice(0, 19);
  }

  getTitleWordCount(): number {
    return this.reclamation.titre.trim().split(/\s+/).filter(w => w.length > 0).length;
  }

  getDescriptionWordCount(): number {
    return this.reclamation.description.trim().split(/\s+/).filter(w => w.length > 0).length;
  }

  isTitleValid(): boolean {
    return this.getTitleWordCount() <= 8;
  }

  isDescriptionValid(): boolean {
    return this.getDescriptionWordCount() >= 10;
  }

  onSubmit(): void {
    if (!this.isTitleValid() || !this.isDescriptionValid()) {
      alert('Please fix the validation errors before submitting.');
      return;
    }

    const reclamationToSend = {
      ...this.reclamation,
      dateCreation: this.reclamation.dateCreation
    };

    this.reclamationService.createReclamation(reclamationToSend).subscribe({
      next: (newReclamation) => {
        console.log('Reclamation created:', newReclamation);
        this.router.navigate(['/admin/reclamations']);
      },
      error: (error) => {
        console.error('Error creating reclamation:', error);
        alert('Failed to create reclamation. Please try again.');
      }
    });
  }

  resetForm(): void {
    this.reclamation = {
      titre: '',
      description: '',
      UserId: 1,
      dateCreation: this.getCurrentDateTime(),
      etat: 'EN_ATTENTE'
    };
  }
}
