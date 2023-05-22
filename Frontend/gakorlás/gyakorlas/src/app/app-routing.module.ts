import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { KolbaszComponent } from './kolbasz/kolbasz.component';
import { HurkaComponent } from './hurka/hurka.component';
import { FooldalComponent } from './fooldal/fooldal.component';

const routes: Routes = [
  { path: 'kolbasz', component: KolbaszComponent },
  { path: 'hurka', component: HurkaComponent },
  { path: 'fooldal', component: FooldalComponent },
  { path: '', redirectTo: '/fooldal', pathMatch: 'full' }, // Alapértelmezett útvonal
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
