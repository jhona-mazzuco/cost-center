import {Component, OnInit} from '@angular/core';
import {CostCenterService} from '../../structure/services/cost-center.service';
import {CostService} from '../../structure/services/cost.service';
import {DialogService, MessageService} from 'primeng';
import {FormCostCenterComponent} from './form-cost-center/form-cost-center.component';
import {FormCostComponent} from './form-cost/form-cost.component';

@Component({
    templateUrl: './cost-center.component.html',
    styleUrls: ['./cost-center.component.scss']
})
export class CostCenterComponent implements OnInit {

    costCenters: any[];
    selected: any;
    costs: any[];

    constructor(
        private service: CostCenterService,
        private costService: CostService,
        private messageService: MessageService,
        private dialog: DialogService
    ) { }

    ngOnInit() {
        this.getCostCenters();
    }

    async getCostCenters() {
        this.costCenters = await this.service.findAll();
        this.selected = undefined;
        this.costs = undefined;
    }

    openFormCostCenter() {
        const dialog = this.dialog.open(FormCostCenterComponent, {
            closable: true,
            header: 'Novo Centro de Custo',
            width: '350px'
        });

        dialog.onClose.subscribe(() => this.getCostCenters());
    }

    openFormCost() {
        const dialog = this.dialog.open(FormCostComponent, {
            closable: true,
            header: 'Novo Custo',
            width: '600px',
            data: {
                costCenter: this.selected.id
            }
        });

        dialog.onClose.subscribe(async () => this.costs = await this.service.getCosts(this.selected.id));
    }

    removeCostCenter(): void {
        if (!this.selected) {
            return;
        }

        this.service.remove(this.selected.id)
            .then(async () => {
                this.selected = undefined;
                this.costs = undefined;
                this.getCostCenters();
            })
            .catch(({ error }) => this.showErrorMessage(error));
    }

    removeCost(row: any) {
        this.costService.remove(row.id)
            .then(async () => this.costs = await this.service.getCosts(this.selected.id));
    }

    onRowSelect(event: any) {
        const { data } = event;
        this.selected = data;
        this.service.getCosts(data.id)
            .then(result => this.costs = result)
            .catch(({ error }) => this.showErrorMessage(error));
    }

    onRowEditSave(row: any) {
        this.costService.update(row)
            .catch(({ error }) => this.showErrorMessage(error));
    }

    private showErrorMessage(message: string) {
        this.messageService.add({
            severity: 'error',
            summary: 'Erro',
            detail: message
        });
    }
}
