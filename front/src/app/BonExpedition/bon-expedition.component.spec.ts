import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BonExpeditionComponent } from './bon-expedition.component';

describe('BonExpeditionComponent', () => {
  let component: BonExpeditionComponent;
  let fixture: ComponentFixture<BonExpeditionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BonExpeditionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BonExpeditionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
