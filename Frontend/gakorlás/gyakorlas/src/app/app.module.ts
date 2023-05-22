import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { KolbaszComponent } from './kolbasz/kolbasz.component';
import { HurkaComponent } from './hurka/hurka.component';
import { FooldalComponent } from './fooldal/fooldal.component';

@NgModule({
  declarations: [
    AppComponent,
    KolbaszComponent,
    HurkaComponent,
    FooldalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
