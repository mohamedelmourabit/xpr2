import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BonsDeRetourComponent } from './bons-de-retour.component';

describe('BonsDeRetourComponent', () => {
  let component: BonsDeRetourComponent;
  let fixture: ComponentFixture<BonsDeRetourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BonsDeRetourComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BonsDeRetourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
