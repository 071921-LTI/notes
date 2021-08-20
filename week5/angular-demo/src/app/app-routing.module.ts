import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutMeComponent } from './components/about-me/about-me.component';
import { ContactMeComponent } from './components/contact-me/contact-me.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { PokehomeComponent } from './components/pokehome/pokehome.component';
import { TtaalComponent } from './components/ttaal/ttaal.component';

const routes: Routes = [{
  path:'',
  component: AboutMeComponent
}, {
  path:'ttaal',
  component: TtaalComponent
}, {
  path:'contact-me',
  component: ContactMeComponent
}, {
  path: 'databinding',
  component: DatabindingComponent
}, {
  path: 'directives',
  component: DirectivesComponent
}, {
  path: 'pokemon',
  component: PokehomeComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
