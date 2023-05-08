import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pet } from '../model/pet';
import { Type } from '../model/type';
import { Color } from '../model/color';
import { Country } from '../model/country';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  private baseUrl: string;
  private typeUrl: string;
  private colorUrl: string;
  private countryUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/api/pets';
    this.typeUrl = 'http://localhost:8080/api/types';
    this.colorUrl = 'http://localhost:8080/api/colors';
    this.countryUrl = 'http://localhost:8080/api/countries';
  }

  public getAll(): Observable<Pet[]> {
    return this.http.get<Pet[]>(this.baseUrl);
  }

  public get(id: any): Observable<Pet> {
    return this.http.get<Pet>(`${this.baseUrl}/${id}`);
  }

  public add(pet: Pet) {
    return this.http.post<Pet>(this.baseUrl, pet);
  }

  public update(id: any, pet: Pet): Observable<Pet> {
    return this.http.put<Pet>(`${this.baseUrl}/${id}`, pet);
  }

  public getTypes(): Observable<Type[]> {
    return this.http.get<Type[]>(this.typeUrl);
  }

  public getColors(): Observable<Color[]> {
    return this.http.get<Color[]>(this.colorUrl);
  }

  public getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(this.countryUrl);
  }
}
