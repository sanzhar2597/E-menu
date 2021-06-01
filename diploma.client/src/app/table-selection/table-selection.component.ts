import { Component, ElementRef, Inject, OnInit, Renderer2 } from '@angular/core';
import { LanguagesService } from '../shared/languages.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { BookingService } from '../shared/booking.service';

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

  public staticTable = {
    'table-part-left': [
      {
        name: 'table-one',
        enable: false,
      },
      {
        name: 'table-two',
        enable: false,

      },
      {
        name: 'table-three',
        enable: false,
      },
      {
        name: 'table-four',
        enable: false,
      },
      {
        name: 'table-five',
        enable: false,
      },
      {
        name: 'table-six',
        enable: false,

      },
      {
        name: 'table-seven',
        enable: false,
      },
      {
        name: 'table-eight',
        enable: false,
      },
      {
        name: 'table-nine',
        enable: false,
      },
      {
        name: 'table-ten',

        enable: false,
      },
      {
        name: 'table-eleven',
        enable: false,

      },
      {
        name: 'table-twelve',
        enable: false,

      },
      {
        name: 'table-thirteen',
        enable: false,

      },
    ],
    'table-part-center-left': [
      {
        name: 'table-fourteen',
        enable: false,

      },
      {
        name: 'table-fifteen',
        enable: false,

      },
      {
        name: 'table-sixteen',
        enable: false,

      },
      {
        name: 'table-seventeen',
        enable: false,

      },
      {
        name: 'table-seventeen-1',
        enable: true,
      },
      {
        name: 'table-seventeen-2',
        enable: true,
      },
      {
        name: 'table-seventeen-3',
        enable: true,
      },
      {
        name: 'table-seventeen-4',
        enable: true,
      },
      {
        name: 'table-seventeen-5',
        enable: true,
      },
      {
        name: 'table-seventeen-6',
        enable: true,
      },
      {
        name: 'table-seventeen-7',
        enable: true,
      },
      {
        name: 'table-seventeen-8',
        enable: true,
      },
      {
        name: 'table-seventeen-9',
        enable: true,
      },
    ],
    'table-part-center': [
      {
        name: 'table-seventeen-20',
        enable: true,
      },
      {
        name: 'table-seventeen-21',
        enable: true,
      },
      {
        name: 'table-seventeen-22',
        enable: true,
      },
      {
        name: 'table-seventeen-23',
        enable: true,
      },
      {
        name: 'table-seventeen-24',
        enable: true,
      },
      {
        name: 'table-seventeen-25',
        enable: true,
      },
      {
        name: 'table-seventeen-26',
        enable: true,
      },
      {
        name: 'table-seventeen-27',
        enable: true,
      },
      {
        name: 'table-seventeen-28',
        enable: true,
      },
      {
        name: 'table-seventeen-29',
        enable: true,
      }


    ],
    'table-part-up': [
      {
        name: 'table-seventeen-10',
        enable: false,
      },
      {
        name: 'table-seventeen-11',
        enable: false,
      },
      {
        name: 'table-seventeen-12',
        enable: false,
      },
      {
        name: 'table-seventeen-13',
        enable: false,
      },
      {
        name: 'table-seventeen-14',
        enable: false,
      },
      {
        name: 'table-seventeen-15',
        enable: false,
      },
      {
        name: 'table-seventeen-16',
        enable: false,
      },
      {
        name: 'table-seventeen-17',
        enable: true,
      },
      {
        name: 'table-seventeen-18',
        enable: true,
      },
      {
        name: 'table-seventeen-19',
        enable: true,
      }
    ],
    'table-part-right': [
      {
        name: 'table-seventeen-37',
        enable: true,
      },
      {
        name: 'table-seventeen-38',
        enable: true,
      },
      {
        name: 'table-seventeen-39',
        enable: true,
      }

    ],

  };


  keys(): Array<string> {
    return Object.keys(this.staticTable);
  }

  createstaticTable() {

    let findTableItem = 0;
    for (let key in this.staticTable) {
      for (let item in this.staticTable[key]) {
        for (let tab in this.data.tableArray) {
          if (this.data.tableArray[tab].name == this.staticTable[key][item].name) {
            this.staticTable[key][item].enable = true;
            this.staticTable[key][item].personNumber = this.data.tableArray[tab].personNumber;
          }
        }
        if (findTableItem == this.data.response) {
          this.selectedItem = this.staticTable[key][item];
        }
        this.staticTable[key][item].id = findTableItem++;

      }
    }
  }

  ngOnInit() {
    this.createstaticTable();
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
