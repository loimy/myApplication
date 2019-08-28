import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { MyApplicationSharedCommonModule, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [MyApplicationSharedCommonModule],
  declarations: [HasAnyAuthorityDirective],
  exports: [MyApplicationSharedCommonModule, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MyApplicationSharedModule {
  static forRoot() {
    return {
      ngModule: MyApplicationSharedModule
    };
  }
}
