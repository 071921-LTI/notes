import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutMeComponent } from './components/about-me/about-me.component';
import { ContactMeComponent } from './components/contact-me/contact-me.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
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
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
