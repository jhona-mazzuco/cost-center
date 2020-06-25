import {Component, OnInit} from '@angular/core';
import {CostCenterService} from '../../structure/services/cost-center.service';

@Component({
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

    data: any;

    constructor(private service: CostCenterService) {
        this.data = {};
    }

    async ngOnInit() {
        const dashboard = await this.service.getDashboard();
        const dataset = dashboard.map((row) => {
            return {
                label: row.name,
                data: [row.value],
                backgroundColor: '#42A5F5',
                borderColor: '#1E88E5',
            };
        });

        this.data = {
            datasets: dataset
        };
    }
}
