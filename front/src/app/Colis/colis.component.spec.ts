import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColisComponent } from './colis.component';

describe('ColisComponent', () => {
  let component: ColisComponent;
  let fixture: ComponentFixture<ColisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ColisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ColisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
