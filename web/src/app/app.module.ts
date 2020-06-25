import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {StructureModule} from './structure/structure.module';
import {RouterModule} from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RestangularModule} from 'ngx-restangular';

export function RestangularConfigFactory(RestangularProvider) {
    RestangularProvider.setBaseUrl('http://localhost:8080/api/');
}

@NgModule({
    declarations: [
        AppComponent,
    ],
    imports: [
        StructureModule,
        BrowserModule,
        BrowserAnimationsModule,
        RestangularModule.forRoot(RestangularConfigFactory),
        RouterModule.forRoot( [
            { path: '', loadChildren: () => import('./pages/dashboard/dashboard.module').then(m => m.DashboardModule) },
            { path: 'cost-center', loadChildren: () => import('./pages/cost-center/cost-center.module').then(m => m.CostCenterModule) }
        ])
    ],
    exports: [
        RestangularModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
