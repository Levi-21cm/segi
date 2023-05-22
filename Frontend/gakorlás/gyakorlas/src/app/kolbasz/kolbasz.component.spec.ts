import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KolbaszComponent } from './kolbasz.component';

describe('KolbaszComponent', () => {
  let component: KolbaszComponent;
  let fixture: ComponentFixture<KolbaszComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [KolbaszComponent]
    });
    fixture = TestBed.createComponent(KolbaszComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
