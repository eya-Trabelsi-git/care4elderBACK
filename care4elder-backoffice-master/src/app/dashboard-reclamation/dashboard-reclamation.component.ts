import { Component, OnInit, ElementRef, ViewChild, AfterViewInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReclamationService } from '../services/reclamation.service';
import Chart from 'chart.js/auto';

interface Reclamation {
  etat: 'EN_ATTENTE' | 'EN_COURS' | 'TRAITEE' | 'REJETEE' | string;
}

@Component({
  selector: 'app-dashboard-reclamation',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-reclamation.component.html',
  styleUrls: ['./dashboard-reclamation.component.css']
})
export class DashboardReclamationComponent implements OnInit, AfterViewInit {
  statutCounts: { [key: string]: number } = {
    EN_ATTENTE: 0,
    EN_COURS: 0,
    TRAITEE: 0,
    REJETEE: 0
  };

  @ViewChild('reclamationChart') reclamationChart!: ElementRef<HTMLCanvasElement>;
  private chart: Chart | undefined;
  private dataLoaded = false;

  constructor(private reclamationService: ReclamationService) {}

  ngOnInit(): void {
    this.loadStatistiques();
  }

  ngAfterViewInit(): void {
    console.log('ngAfterViewInit - reclamationChart:', this.reclamationChart);
    if (this.dataLoaded) {
      this.initializeChart();
    }
  }

  loadStatistiques(): void {
    this.statutCounts = {
      EN_ATTENTE: 0,
      EN_COURS: 0,
      TRAITEE: 0,
      REJETEE: 0
    };

    this.reclamationService.getAllReclamations().subscribe(
      (data: Reclamation[]) => {
        console.log('API Response:', data);
        data.forEach(rec => {
          if (this.statutCounts.hasOwnProperty(rec.etat)) {
            this.statutCounts[rec.etat]++;
          }
        });

        this.dataLoaded = true;
        if (this.reclamationChart) {
          this.initializeChart();
        }
      },
      error => {
        console.error('Erreur lors du chargement des réclamations', error);
        this.dataLoaded = true;
      }
    );
  }

  initializeChart(): void {
    if (!this.reclamationChart) {
      console.error('reclamationChart is not available');
      return;
    }

    const ctx = this.reclamationChart.nativeElement.getContext('2d');
    if (ctx) {
      if (this.chart) {
        this.chart.destroy();
      }

      this.chart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: ['EN_ATTENTE',  'TRAITEE', 'REJETEE'],
          datasets: [{
            label: 'Nombre de Réclamations',
            data: [
              this.statutCounts['EN_ATTENTE'],
          
              this.statutCounts['TRAITEE'],
              this.statutCounts['REJETEE']
            ],
            backgroundColor: [
              'rgba(255, 99, 132, 0.5)',
            
              'rgba(75, 192, 192, 0.5)',
              'rgba(255, 206, 86, 0.5)'
            ],
            borderColor: [
              'rgba(255, 99, 132, 1)',
       
              'rgba(75, 192, 192, 1)',
              'rgba(255, 206, 86, 1)'
            ],
            borderWidth: 1
          }]
        },
        options: {
          scales: {
            y: {
              beginAtZero: true,
              title: {
                display: true,
                text: 'Nombre de Réclamations'
              }
            },
            x: {
              title: {
                display: true,
                text: 'Statut'
              }
            }
          },
          plugins: {
            legend: {
              display: true,
              position: 'top'
            }
          }
        }
      });
    } else {
      console.error('Canvas context is not available');
    }
  }
}