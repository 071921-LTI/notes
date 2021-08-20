import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { BannerComponent } from './components/banner/banner.component';
import { FooterComponent } from './components/footer/footer.component';
import { AboutMeComponent } from './components/about-me/about-me.component';
import { TtaalComponent } from './components/ttaal/ttaal.component';
import { ContactMeComponent } from './components/contact-me/contact-me.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { FormsModule } from '@angular/forms';
import { MyComponentComponent } from './components/my-component/my-component.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { MyPipePipe } from './pipes/my-pipe.pipe';
import { PokehomeComponent } from './components/pokehome/pokehome.component';
import { PokemonComponent } from './components/pokemon/pokemon.component';


@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    BannerComponent,
    FooterComponent,
    AboutMeComponent,
    TtaalComponent,
    ContactMeComponent,
    DatabindingComponent,
    MyComponentComponent,
    DirectivesComponent,
    MyPipePipe,
    PokehomeComponent,
    PokemonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
