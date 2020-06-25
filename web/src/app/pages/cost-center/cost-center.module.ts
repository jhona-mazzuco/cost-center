import {NgModule} from '@angular/core';
import {CostCenterComponent} from './cost-center.component';
import {FormCostCenterComponent} from './form-cost-center/form-cost-center.component';
import {FormCostComponent} from './form-cost/form-cost.component';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {StructureModule} from '../../structure/structure.module';

@NgModule({
    declarations: [
        CostCenterComponent,
        FormCostCenterComponent,
        FormCostComponent,
    ],
    imports: [
        CommonModule,
        StructureModule,
        RouterModule.forChild([{ path: '', component: CostCenterComponent }])
    ]
})
export class CostCenterModule {
}
