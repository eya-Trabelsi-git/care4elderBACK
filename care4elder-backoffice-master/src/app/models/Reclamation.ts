
export interface Reclamation {
  id?: number;  
  titre: string;
  UserId:number;
  description: string;
  dateCreation: string;  
  etat: 'EN_ATTENTE' | 'TRAITEE' | 'REJETEE' | 'NON_AFFECTEE';
}