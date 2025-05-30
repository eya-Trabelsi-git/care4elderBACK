import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; 
import { ReclamationService } from '../services/reclamation.service';
import { Reclamation } from '../models/Reclamation';

@Component({
  selector: 'app-reclamation-edit',
  standalone: true,
  imports: [CommonModule, FormsModule], 
  templateUrl: './reclamation-edit.component.html',
  styleUrls: ['./reclamation-edit.component.css']
})
export class ReclamationEditComponent implements OnInit {
  reclamation: Reclamation | null = null;
  isLoading = true;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private reclamationService: ReclamationService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));  
    this.loadReclamation(id);
  }

  loadReclamation(id: number): void {
    this.reclamationService.getReclamationById(id).subscribe(
      (data) => {
        this.reclamation = data;
        this.isLoading = false;
      },
      (error) => {
        console.error('Error loading reclamation:', error);
        this.isLoading = false;
      }
    );
  }

  // Update the reclamation
  updateReclamation(): void {
    if (this.reclamation?.id) { 
      this.reclamationService.updateReclamation(this.reclamation.id, this.reclamation).subscribe(
        (updatedReclamation) => {
          this.router.navigate(['/admin/reclamations']);  
          alert('Reclamation updated successfully');
        },
        (error) => {
          console.error('Error updating reclamation:', error);
          alert('Failed to update reclamation');
        }
      );
    } else {
      console.error('Reclamation is null or has no id.');
    }
  }

  cancelEdit(): void {
    this.router.navigate(['/']); 
  }
}
