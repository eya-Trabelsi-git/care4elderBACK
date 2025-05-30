import { Component, OnInit, ViewEncapsulation } from '@angular/core'; 
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { ReclamationService } from '../services/reclamation.service';
import { Reclamation } from '../models/Reclamation';

@Component({
  selector: 'app-reclamation-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './reclamation-list.component.html',
  styleUrls: ['./reclamation-list.component.css'],
  encapsulation: ViewEncapsulation.None 
})
export class ReclamationListComponent implements OnInit {
  reclamations: Reclamation[] = [];
  isLoading = true;

  constructor(private reclamationService: ReclamationService, private router: Router) {}

  ngOnInit(): void {
    this.loadReclamations();
  }

  loadReclamations(): void {
    this.reclamationService.getAllReclamations().subscribe(
      (data) => {
        this.reclamations = data;
        this.isLoading = false;
      },
      (error) => {
        console.error('Error loading reclamations:', error);
        this.isLoading = false;
      }
    );
  }

  editReclamation(id: number | undefined): void {
    if (id !== undefined) {
      this.router.navigate(['/reclamations/edit', id]);
    } else {
      console.error('Reclamation ID is undefined');
    }
  }

  deleteReclamation(id: number | undefined): void {
    if (id !== undefined) {
      if (confirm('Are you sure you want to delete this reclamation?')) {
        this.reclamationService.deleteReclamation(id).subscribe(
          () => {
            this.loadReclamations();
            alert('Reclamation deleted successfully');
          },
          (error) => {
            console.error('Error deleting reclamation:', error);
            alert('Failed to delete reclamation');
          }
        );
      }
    } else {
      console.error('Reclamation ID is undefined');
    }
  }

  isUrgent(reclamation: Reclamation): boolean {
    const description = reclamation.description?.toLowerCase() || '';
    return description.includes('urgent');
  }
  
  
}