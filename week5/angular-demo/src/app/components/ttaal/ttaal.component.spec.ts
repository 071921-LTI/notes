import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TtaalComponent } from './ttaal.component';

describe('TtaalComponent', () => {
  let component: TtaalComponent;
  let fixture: ComponentFixture<TtaalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TtaalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TtaalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
