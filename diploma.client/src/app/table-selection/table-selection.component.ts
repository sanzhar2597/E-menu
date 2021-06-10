import {Component, ElementRef, Inject, OnInit, Renderer2} from '@angular/core';
import {LanguagesService} from '../shared/languages.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {BookingService} from '../shared/booking.service';

@Component({
  selector: 'app-table-selection',
  templateUrl: './table-selection.component.html',
  styleUrls: ['./table-selection.component.css']
})
export class TableSelectionComponent implements OnInit {

  public selectedItem: any = {};
  public selectedId: number;

  constructor(@Inject(MAT_DIALOG_DATA) public data,
              public dialogRef: MatDialogRef<TableSelectionComponent>,
              private bookingService: BookingService,
              public languagesService: LanguagesService,
              private el: ElementRef,
              private renderer: Renderer2
  ) {
  }

  public copyStaticTable;

  public staticTable = {
    'table-part-left': [
      {
        name: 'place-1',
        enable: false,
      },
      {
        name: 'place-5',
        enable: false,

      },
      {
        name: 'place-9',
        enable: false,
      },
      {
        name: 'place-13',
        enable: false,
      },
      {
        name: 'place-17',
        enable: false,
      },
      {
        name: 'place-21',
        enable: false,

      },
      {
        name: 'place-23',
        enable: false,
      },
      {
        name: 'place-25',
        enable: false,
      },
      {
        name: 'place-29',
        enable: false,
      },
      {
        name: 'place-33',

        enable: false,
      },
      {
        name: 'place-37',
        enable: false,

      },
      {
        name: 'place-41',
        enable: false,

      },
      {
        name: 'place-45',
        enable: false,

      },
    ],
    'table-part-center-left': [
      {
        name: 'place-2',
        enable: false,
      },
      {
        name: 'place-6',
        enable: false,

      },
      {
        name: 'place-10',
        enable: false,

      },
      {
        name: 'place-14',
        enable: false,

      },
      {
        name: 'place-18',
        enable: false,
      },
      {
        name: 'place-22',
        enable: false,
      },
      {
        name: 'place-24',
        enable: false,
      },
      {
        name: 'place-26',
        enable: false,
      },
      {
        name: 'place-30',
        enable: false,
      },
      {
        name: 'place-34',
        enable: false,
      },
      {
        name: 'place-38',
        enable: false,
      },
      {
        name: 'place-42',
        enable: false,
      },
      {
        name: 'place-46',
        enable: false,
      },
    ],
    'table-part-center': [
      {
        name: 'place-3',
        enable: false,
      },
      {
        name: 'place-7',
        enable: false,
      },
      {
        name: 'place-11',
        enable: false,
      },
      {
        name: 'place-15',
        enable: false,
      },
      {
        name: 'place-19',
        enable: false,
      },
      {
        name: 'place-27',
        enable: false,
      },
      {
        name: 'place-31',
        enable: false,
      },
      {
        name: 'place-35',
        enable: false,
      },
      {
        name: 'place-39',
        enable: false,
      },
      {
        name: 'place-43',
        enable: false,
      }


    ],
    'table-part-up': [
      {
        name: 'place-4',
        enable: false,
      },
      {
        name: 'place-8',
        enable: false,
      },
      {
        name: 'place-12',
        enable: false,
      },
      {
        name: 'place-16',
        enable: false,
      },
      {
        name: 'place-20',
        enable: false,
      },
      {
        name: 'place-28',
        enable: false,
      },
      {
        name: 'place-32',
        enable: false,
      },
      {
        name: 'place-36',
        enable: false,
      },
      {
        name: 'place-40',
        enable: false,
      },
      {
        name: 'place-44',
        enable: false,
      }
    ],
    'table-part-right': [
      {
        name: 'place-47',
        enable: false,
      },
      {
        name: 'place-48',
        enable: false,
      },
      {
        name: 'place-49',
        enable: false,
      }

    ],

  };


  keys(): Array<string> {
    return Object.keys(this.staticTable);
  }

  createstaticTable() {
    this.copyStaticTable = JSON.parse(JSON.stringify(this.staticTable));
    let findTableItem = 0;
    for (let key in this.copyStaticTable) {
      for (let item in this.copyStaticTable[key]) {
        for (let tab in this.data.tableArray) {
          if (this.data.tableArray[tab].name === this.copyStaticTable[key][item].name) {
            if (this.copyStaticTable[key][item].name === 'place-2') {
              console.error(this.data.tableArray[tab].name, this.copyStaticTable[key][item].name);
            }
            this.copyStaticTable[key][item].enable = true;
            this.copyStaticTable[key][item].personNumber = this.data.tableArray[tab].personNumber;
          }
        }
        if (findTableItem === this.data.response) {
          this.selectedItem = this.copyStaticTable[key][item];
        }
        this.copyStaticTable[key][item].id = findTableItem++;

      }
    }
    console.error(this.copyStaticTable);
  }

  ngOnInit() {
    // this.createstaticTable();
    this.bookingService.getRestaurantTableByBookingList(this.data.booking).then(value => {
        this.data.tableArray = value.body;
        this.createstaticTable();
      }
    );
  }


  chooseTable(item: any) {
    let answerBack: any;
    this.selectedItem = item;
    if (this.selectedItem.enable) {

      setTimeout(() => {
        this.dialogRef.close(this.selectedItem);

      }, 200);
    }
  }

}
