import { Component, OnInit } from '@angular/core';
import { Pet } from '../model/pet';
import { Type } from '../model/type';
import { Color } from '../model/color';
import { Country } from '../model/country';
import { ActivatedRoute, Router } from '@angular/router';
import { PetService } from '../service/pet.service';

@Component({
  selector: 'app-pet-add',
  templateUrl: './pet-add.component.html',
  styleUrls: ['./pet-add.component.css']
})
export class PetAddComponent implements OnInit {

  form = {
    name: '', 
    code: '', 
    type: '', 
    color: '', 
    country: ''
  }

  pet: Pet;
  types?: Type[];
  colors?: Color[];
  countries?: Country[];

  constructor(private route: ActivatedRoute, private router: Router, private petService: PetService) {
    this.pet = new Pet();
  }

  ngOnInit(): void {
      this.petService.getTypes().subscribe(data => { this.types = data });
      this.petService.getColors().subscribe(data => { this.colors = data });
      this.petService.getCountries().subscribe(data => { this.countries = data });
  }

  onSubmit() {
    this.petService.add(this.pet).subscribe(result => this.goToPetList());
  }

  goToPetList() {
    this.router.navigate(['/pets']);
  }
}
