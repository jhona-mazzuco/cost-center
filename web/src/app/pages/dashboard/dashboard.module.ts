import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {DashboardComponent} from './dashboard.component';
import {StructureModule} from '../../structure/structure.module';

@NgModule({
    declarations: [DashboardComponent],
    imports: [
        CommonModule,
        RouterModule.forChild([{ path: '', component: DashboardComponent }]),
        StructureModule
    ]
})
export class DashboardModule {
}
