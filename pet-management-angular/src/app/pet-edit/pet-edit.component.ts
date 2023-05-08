import { Component, Input, OnInit } from '@angular/core';
import { Pet } from '../model/pet';
import { Type } from '../model/type';
import { Color } from '../model/color';
import { Country } from '../model/country';
import { ActivatedRoute, Router } from '@angular/router';
import { PetService } from '../service/pet.service';

@Component({
  selector: 'app-pet-edit',
  templateUrl: './pet-edit.component.html',
  styleUrls: ['./pet-edit.component.css']
})
export class PetEditComponent implements OnInit {

  @Input() currentPet: Pet = {
    name: '', 
    code: 0n, 
    type: '', 
    color: '', 
    country: ''
  }

  form = {
    name: this.currentPet.name, 
    code: this.currentPet.code, 
    type: this.currentPet.type, 
    color: this.currentPet.color, 
    country: this.currentPet.country
  }

  types?: Type[];
  colors?: Color[];
  countries?: Country[];

  constructor(private route: ActivatedRoute, private router: Router, private petService: PetService) { }

  ngOnInit(): void {
    this.petService.getTypes().subscribe(data => this.types = data);
    this.petService.getColors().subscribe(data => this.colors = data);
    this.petService.getCountries().subscribe(data => this.countries = data);
    this.getPet(this.route.snapshot.params["id"]);
  }

  getPet(id: string): void {
    this.petService.get(id).subscribe(data => this.currentPet = data);
  }

  onSubmit() {
    this.petService.update(this.currentPet.id, this.currentPet).subscribe(result => this.goToPetList());
  }

  goToPetList() {
    this.router.navigate(['/pets']);
  }
}
