import { Component } from '@angular/core';
import { MenuItem } from 'primeng';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.scss']
})
export class TopbarComponent {

    items: MenuItem[];

    constructor() {
        this.items = [
            { label: 'Dashboard', icon: 'pi pi-home', url: '/' },
            { label: 'Centro de custo', url: '/cost-center', }
        ];
    }
}
