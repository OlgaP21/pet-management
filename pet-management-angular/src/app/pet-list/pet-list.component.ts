import { Component, OnInit } from '@angular/core';
import { Pet } from '../model/pet';
import { PetService } from '../service/pet.service';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.css']
})
export class PetListComponent implements OnInit {

  pets?: Pet[];

  headers = ['#', 'Name', 'Code', 'Type', 'Color', 'Country'];

  constructor(private petService: PetService) { }

  ngOnInit(): void {
      this.petService.getAll().subscribe(data => this.pets = data);
  }
}
