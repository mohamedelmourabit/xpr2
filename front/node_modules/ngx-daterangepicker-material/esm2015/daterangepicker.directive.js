var DaterangepickerDirective_1;
import { __decorate } from "tslib";
import { Directive, ViewContainerRef, ComponentFactoryResolver, ElementRef, HostListener, forwardRef, ChangeDetectorRef, OnInit, OnChanges, SimpleChanges, Input, DoCheck, KeyValueDiffer, KeyValueDiffers, Output, EventEmitter, Renderer2, HostBinding } from '@angular/core';
import { DaterangepickerComponent } from './daterangepicker.component';
import { NG_VALUE_ACCESSOR } from '@angular/forms';
import * as _moment from 'moment';
import { LocaleService } from './locale.service';
const moment = _moment;
let DaterangepickerDirective = DaterangepickerDirective_1 = class DaterangepickerDirective {
    constructor(viewContainerRef, _changeDetectorRef, _componentFactoryResolver, _el, _renderer, differs, _localeService, elementRef) {
        this.viewContainerRef = viewContainerRef;
        this._changeDetectorRef = _changeDetectorRef;
        this._componentFactoryResolver = _componentFactoryResolver;
        this._el = _el;
        this._renderer = _renderer;
        this.differs = differs;
        this._localeService = _localeService;
        this.elementRef = elementRef;
        this._onChange = Function.prototype;
        this._onTouched = Function.prototype;
        this._validatorChange = Function.prototype;
        this.dateLimit = null;
        this.showCancel = false;
        this.lockStartDate = false;
        // timepicker variables
        this.timePicker = false;
        this.timePicker24Hour = false;
        this.timePickerIncrement = 1;
        this.timePickerSeconds = false;
        this.closeOnAutoApply = true;
        this._locale = {};
        this._endKey = 'endDate';
        this._startKey = 'startDate';
        this.notForChangesProperty = [
            'locale',
            'endKey',
            'startKey'
        ];
        this.onChange = new EventEmitter();
        this.rangeClicked = new EventEmitter();
        this.datesUpdated = new EventEmitter();
        this.startDateChanged = new EventEmitter();
        this.endDateChanged = new EventEmitter();
        this.drops = 'down';
        this.opens = 'auto';
        const componentFactory = this._componentFactoryResolver.resolveComponentFactory(DaterangepickerComponent);
        viewContainerRef.clear();
        const componentRef = viewContainerRef.createComponent(componentFactory);
        this.picker = componentRef.instance;
        this.picker.inline = false; // set inline to false for all directive usage
    }
    set locale(value) {
        this._locale = Object.assign(Object.assign({}, this._localeService.config), value);
    }
    get locale() {
        return this._locale;
    }
    set startKey(value) {
        if (value !== null) {
            this._startKey = value;
        }
        else {
            this._startKey = 'startDate';
        }
    }
    set endKey(value) {
        if (value !== null) {
            this._endKey = value;
        }
        else {
            this._endKey = 'endDate';
        }
    }
    get value() {
        return this._value || null;
    }
    set value(val) {
        this._value = val;
        this._onChange(val);
        this._changeDetectorRef.markForCheck();
    }
    get disabled() { return this._disabled; }
    ngOnInit() {
        this.picker.startDateChanged.asObservable().subscribe((itemChanged) => {
            this.startDateChanged.emit(itemChanged);
        });
        this.picker.endDateChanged.asObservable().subscribe((itemChanged) => {
            this.endDateChanged.emit(itemChanged);
        });
        this.picker.rangeClicked.asObservable().subscribe((range) => {
            this.rangeClicked.emit(range);
        });
        this.picker.datesUpdated.asObservable().subscribe((range) => {
            this.datesUpdated.emit(range);
        });
        this.picker.choosedDate.asObservable().subscribe((change) => {
            if (change) {
                const value = {};
                value[this._startKey] = change.startDate;
                value[this._endKey] = change.endDate;
                this.value = value;
                this.onChange.emit(value);
                if (typeof change.chosenLabel === 'string') {
                    this._el.nativeElement.value = change.chosenLabel;
                }
            }
        });
        this.picker.firstMonthDayClass = this.firstMonthDayClass;
        this.picker.lastMonthDayClass = this.lastMonthDayClass;
        this.picker.emptyWeekRowClass = this.emptyWeekRowClass;
        this.picker.emptyWeekColumnClass = this.emptyWeekColumnClass;
        this.picker.firstDayOfNextMonthClass = this.firstDayOfNextMonthClass;
        this.picker.lastDayOfPreviousMonthClass = this.lastDayOfPreviousMonthClass;
        this.picker.drops = this.drops;
        this.picker.opens = this.opens;
        this.localeDiffer = this.differs.find(this.locale).create();
        this.picker.closeOnAutoApply = this.closeOnAutoApply;
    }
    ngOnChanges(changes) {
        for (const change in changes) {
            if (changes.hasOwnProperty(change)) {
                if (this.notForChangesProperty.indexOf(change) === -1) {
                    this.picker[change] = changes[change].currentValue;
                }
            }
        }
    }
    ngDoCheck() {
        if (this.localeDiffer) {
            const changes = this.localeDiffer.diff(this.locale);
            if (changes) {
                this.picker.updateLocale(this.locale);
            }
        }
    }
    onBlur() {
        this._onTouched();
    }
    open(event) {
        if (this.disabled) {
            return;
        }
        this.picker.show(event);
        setTimeout(() => {
            this.setPosition();
        });
    }
    hide(e) {
        this.picker.hide(e);
    }
    toggle(e) {
        if (this.picker.isShown) {
            this.hide(e);
        }
        else {
            this.open(e);
        }
    }
    clear() {
        this.picker.clear();
    }
    writeValue(value) {
        this.setValue(value);
    }
    registerOnChange(fn) {
        this._onChange = fn;
    }
    registerOnTouched(fn) {
        this._onTouched = fn;
    }
    setDisabledState(state) {
        this._disabled = state;
    }
    setValue(val) {
        if (val) {
            this.value = val;
            if (val[this._startKey]) {
                this.picker.setStartDate(val[this._startKey]);
            }
            if (val[this._endKey]) {
                this.picker.setEndDate(val[this._endKey]);
            }
            this.picker.calculateChosenLabel();
            if (this.picker.chosenLabel) {
                this._el.nativeElement.value = this.picker.chosenLabel;
            }
        }
        else {
            this.picker.clear();
        }
    }
    /**
     * Set position of the calendar
     */
    setPosition() {
        let style;
        let containerTop;
        const container = this.picker.pickerContainer.nativeElement;
        const element = this._el.nativeElement;
        if (this.drops && this.drops === 'up') {
            containerTop = (element.offsetTop - container.clientHeight) + 'px';
        }
        else {
            containerTop = 'auto';
        }
        if (this.opens === 'left') {
            style = {
                top: containerTop,
                left: (element.offsetLeft - container.clientWidth + element.clientWidth) + 'px',
                right: 'auto'
            };
        }
        else if (this.opens === 'center') {
            style = {
                top: containerTop,
                left: (element.offsetLeft + element.clientWidth / 2
                    - container.clientWidth / 2) + 'px',
                right: 'auto'
            };
        }
        else if (this.opens === 'right') {
            style = {
                top: containerTop,
                left: element.offsetLeft + 'px',
                right: 'auto'
            };
        }
        else {
            const position = element.offsetLeft + element.clientWidth / 2 - container.clientWidth / 2;
            if (position < 0) {
                style = {
                    top: containerTop,
                    left: element.offsetLeft + 'px',
                    right: 'auto'
                };
            }
            else {
                style = {
                    top: containerTop,
                    left: position + 'px',
                    right: 'auto'
                };
            }
        }
        if (style) {
            this._renderer.setStyle(container, 'top', style.top);
            this._renderer.setStyle(container, 'left', style.left);
            this._renderer.setStyle(container, 'right', style.right);
        }
    }
    inputChanged(e) {
        if (e.target.tagName.toLowerCase() !== 'input') {
            return;
        }
        if (!e.target.value.length) {
            return;
        }
        const dateString = e.target.value.split(this.picker.locale.separator);
        let start = null, end = null;
        if (dateString.length === 2) {
            start = moment(dateString[0], this.picker.locale.format);
            end = moment(dateString[1], this.picker.locale.format);
        }
        if (this.singleDatePicker || start === null || end === null) {
            start = moment(e.target.value, this.picker.locale.format);
            end = start;
        }
        if (!start.isValid() || !end.isValid()) {
            return;
        }
        this.picker.setStartDate(start);
        this.picker.setEndDate(end);
        this.picker.updateView();
    }
    /**
     * For click outside of the calendar's container
     * @param event event object
     */
    outsideClick(event) {
        if (!event.target) {
            return;
        }
        if (event.target.classList.contains('ngx-daterangepicker-action')) {
            return;
        }
        if (!this.elementRef.nativeElement.contains(event.target)) {
            this.hide();
        }
    }
};
DaterangepickerDirective.ctorParameters = () => [
    { type: ViewContainerRef },
    { type: ChangeDetectorRef },
    { type: ComponentFactoryResolver },
    { type: ElementRef },
    { type: Renderer2 },
    { type: KeyValueDiffers },
    { type: LocaleService },
    { type: ElementRef }
];
__decorate([
    Input()
], DaterangepickerDirective.prototype, "minDate", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "maxDate", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "autoApply", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "alwaysShowCalendars", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "showCustomRangeLabel", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "linkedCalendars", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "dateLimit", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "singleDatePicker", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "showWeekNumbers", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "showISOWeekNumbers", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "showDropdowns", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "isInvalidDate", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "isCustomDate", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "isTooltipDate", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "showClearButton", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "customRangeDirection", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "ranges", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "opens", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "drops", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "lastMonthDayClass", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "emptyWeekRowClass", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "emptyWeekColumnClass", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "firstDayOfNextMonthClass", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "lastDayOfPreviousMonthClass", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "keepCalendarOpeningWithRange", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "showRangeLabelOnInput", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "showCancel", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "lockStartDate", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "timePicker", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "timePicker24Hour", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "timePickerIncrement", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "timePickerSeconds", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "closeOnAutoApply", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "locale", null);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "_endKey", void 0);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "startKey", null);
__decorate([
    Input()
], DaterangepickerDirective.prototype, "endKey", null);
__decorate([
    Output('change')
], DaterangepickerDirective.prototype, "onChange", void 0);
__decorate([
    Output('rangeClicked')
], DaterangepickerDirective.prototype, "rangeClicked", void 0);
__decorate([
    Output('datesUpdated')
], DaterangepickerDirective.prototype, "datesUpdated", void 0);
__decorate([
    Output()
], DaterangepickerDirective.prototype, "startDateChanged", void 0);
__decorate([
    Output()
], DaterangepickerDirective.prototype, "endDateChanged", void 0);
__decorate([
    HostBinding('disabled')
], DaterangepickerDirective.prototype, "disabled", null);
__decorate([
    HostListener('document:click', ['$event'])
], DaterangepickerDirective.prototype, "outsideClick", null);
DaterangepickerDirective = DaterangepickerDirective_1 = __decorate([
    Directive({
        selector: 'input[ngxDaterangepickerMd]',
        host: {
            '(keyup.esc)': 'hide()',
            '(blur)': 'onBlur()',
            '(click)': 'open()',
            '(keyup)': 'inputChanged($event)'
        },
        providers: [
            {
                provide: NG_VALUE_ACCESSOR,
                useExisting: forwardRef(() => DaterangepickerDirective_1), multi: true
            }
        ]
    })
], DaterangepickerDirective);
export { DaterangepickerDirective };
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiZGF0ZXJhbmdlcGlja2VyLmRpcmVjdGl2ZS5qcyIsInNvdXJjZVJvb3QiOiJuZzovL25neC1kYXRlcmFuZ2VwaWNrZXItbWF0ZXJpYWwvIiwic291cmNlcyI6WyJkYXRlcmFuZ2VwaWNrZXIuZGlyZWN0aXZlLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7O0FBQUEsT0FBTyxFQUNMLFNBQVMsRUFDVCxnQkFBZ0IsRUFDaEIsd0JBQXdCLEVBQ3hCLFVBQVUsRUFDVixZQUFZLEVBQ1osVUFBVSxFQUNWLGlCQUFpQixFQUNqQixNQUFNLEVBQ04sU0FBUyxFQUNULGFBQWEsRUFDYixLQUFLLEVBQ0wsT0FBTyxFQUNQLGNBQWMsRUFDZCxlQUFlLEVBQ2YsTUFBTSxFQUNOLFlBQVksRUFDWixTQUFTLEVBQ1QsV0FBVyxFQUNaLE1BQU0sZUFBZSxDQUFDO0FBQ3ZCLE9BQU8sRUFBRSx3QkFBd0IsRUFBRSxNQUFNLDZCQUE2QixDQUFDO0FBQ3ZFLE9BQU8sRUFBRSxpQkFBaUIsRUFBRSxNQUFNLGdCQUFnQixDQUFDO0FBQ25ELE9BQU8sS0FBSyxPQUFPLE1BQU0sUUFBUSxDQUFDO0FBRWxDLE9BQU8sRUFBRSxhQUFhLEVBQUUsTUFBTSxrQkFBa0IsQ0FBQztBQUNqRCxNQUFNLE1BQU0sR0FBRyxPQUFPLENBQUM7QUFpQnZCLElBQWEsd0JBQXdCLGdDQUFyQyxNQUFhLHdCQUF3QjtJQXVIbkMsWUFDUyxnQkFBa0MsRUFDbEMsa0JBQXFDLEVBQ3BDLHlCQUFtRCxFQUNuRCxHQUFlLEVBQ2YsU0FBb0IsRUFDcEIsT0FBd0IsRUFDeEIsY0FBNkIsRUFDN0IsVUFBc0I7UUFQdkIscUJBQWdCLEdBQWhCLGdCQUFnQixDQUFrQjtRQUNsQyx1QkFBa0IsR0FBbEIsa0JBQWtCLENBQW1CO1FBQ3BDLDhCQUF5QixHQUF6Qix5QkFBeUIsQ0FBMEI7UUFDbkQsUUFBRyxHQUFILEdBQUcsQ0FBWTtRQUNmLGNBQVMsR0FBVCxTQUFTLENBQVc7UUFDcEIsWUFBTyxHQUFQLE9BQU8sQ0FB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U0FBUyxFQUFFLFFBQVE7WUFDbkIsU0FBUyxFQUFFLHNCQUFzQjtTQUNsQztRQUNELFNBQVMsRUFBRTtZQUNUO2dCQUNFLE9BQU8sRUFBRSxpQkFBaUI7Z0JBQzFCLFdBQVcsRUFBRSxVQUFVLENBQUMsR0FBRyxFQUFFLENBQUMsMEJBQXdCLENBQUMsRUFBRSxLQUFLLEVBQUUsSUFBSTthQUNyRTtTQUNKO0tBQ0EsQ0FBQztHQUNXLHdCQUF3QixDQTZWcEM7U0E3Vlksd0JBQXdCIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtcbiAgRGlyZWN0aXZlLFxuICBWaWV3Q29udGFpbmVyUmVmLFxuICBDb21wb25lbnRGYWN0b3J5UmVzb2x2ZXIsXG4gIEVsZW1lbnRSZWYsXG4gIEhvc3RMaXN0ZW5lcixcbiAgZm9yd2FyZFJlZixcbiAgQ2hhbmdlRGV0ZWN0b3JSZWYsXG4gIE9uSW5pdCxcbiAgT25DaGFuZ2VzLFxuICBTaW1wbGVDaGFuZ2VzLFxuICBJbnB1dCxcbiAgRG9DaGVjayxcbiAgS2V5VmFsdWVEaWZmZXIsXG4gIEtleVZhbHVlRGlmZmVycyxcbiAgT3V0cHV0LFxuICBFdmVudEVtaXR0ZXIsXG4gIFJlbmRlcmVyMixcbiAgSG9zdEJpbmRpbmdcbn0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XG5pbXBvcnQgeyBEYXRlcmFuZ2VwaWNrZXJDb21wb25lbnQgfSBmcm9tICcuL2RhdGVyYW5nZXBpY2tlci5jb21wb25lbnQnO1xuaW1wb3J0IHsgTkdfVkFMVUVfQUNDRVNTT1IgfSBmcm9tICdAYW5ndWxhci9mb3Jtcyc7XG5pbXBvcnQgKiBhcyBfbW9tZW50IGZyb20gJ21vbWVudCc7XG5pbXBvcnQgeyBMb2NhbGVDb25maWcgfSBmcm9tICcuL2RhdGVyYW5nZXBpY2tlci5jb25maWcnO1xuaW1wb3J0IHsgTG9jYWxlU2VydmljZSB9IGZyb20gJy4vbG9jYWxlLnNlcnZpY2UnO1xuY29uc3QgbW9tZW50ID0gX21vbWVudDtcblxuQERpcmVjdGl2ZSh7XG4gIHNlbGVjdG9yOiAnaW5wdXRbbmd4RGF0ZXJhbmdlcGlja2VyTWRdJyxcbiAgaG9zdDoge1xuICAgICcoa2V5dXAuZXNjKSc6ICdoaWRlKCknLFxuICAgICcoYmx1ciknOiAnb25CbHVyKCknLFxuICAgICcoY2xpY2spJzogJ29wZW4oKScsXG4gICAgJyhrZXl1cCknOiAnaW5wdXRDaGFuZ2VkKCRldmVudCknXG4gIH0sXG4gIHByb3ZpZGVyczogW1xuICAgIHtcbiAgICAgIHByb3ZpZGU6IE5HX1ZBTFVFX0FDQ0VTU09SLFxuICAgICAgdXNlRXhpc3Rpbmc6IGZvcndhcmRSZWYoKCkgPT4gRGF0ZXJhbmdlcGlja2VyRGlyZWN0aXZlKSwgbXVsdGk6IHRydWVcbiAgICB9XG5dXG59KVxuZXhwb3J0IGNsYXNzIERhdGVyYW5nZXBpY2tlckRpcmVjdGl2ZSBpbXBsZW1lbnRzIE9uSW5pdCwgT25DaGFuZ2VzLCBEb0NoZWNrIHtcbiAgcHVibGljIHBpY2tlcjogRGF0ZXJhbmdlcGlja2VyQ29tcG9uZW50O1xuICBwcml2YXRlIF9vbkNoYW5nZSA9IEZ1bmN0aW9uLnByb3RvdHlwZTtcbiAgcHJpdmF0ZSBfb25Ub3VjaGVkID0gRnVuY3Rpb24ucHJvdG90eXBlO1xuICBwcml2YXRlIF92YWxpZGF0b3JDaGFuZ2UgPSBGdW5jdGlvbi5wcm90b3R5cGU7XG4gIHByaXZhdGUgX2Rpc2FibGVkOiBib29sZWFuO1xuICBwcml2YXRlIF92YWx1ZTogYW55O1xuICBwcml2YXRlIGxvY2FsZURpZmZlcjogS2V5VmFsdWVEaWZmZXI8c3RyaW5nLCBhbnk+O1xuICBASW5wdXQoKVxuICBtaW5EYXRlOiBfbW9tZW50Lk1vbWVudFxuICBASW5wdXQoKVxuICBtYXhEYXRlOiBfbW9tZW50Lk1vbWVudFxuICBASW5wdXQoKVxuICBhdXRvQXBwbHk6IGJvb2xlYW47XG4gIEBJbnB1dCgpXG4gIGFsd2F5c1Nob3dDYWxlbmRhcnM6IGJvb2xlYW47XG4gIEBJbnB1dCgpXG4gIHNob3dDdXN0b21SYW5nZUxhYmVsOiBib29sZWFuO1xuICBASW5wdXQoKVxuICBsaW5rZWRDYWxlbmRhcnM6IGJvb2xlYW47XG4gIEBJbnB1dCgpXG4gIGRhdGVMaW1pdDogbnVtYmVyID0gbnVsbDtcbiAgQElucHV0KClcbiAgc2luZ2xlRGF0ZVBpY2tlcjogYm9vbGVhbjtcbiAgQElucHV0KClcbiAgc2hvd1dlZWtOdW1iZXJzOiBib29sZWFuO1xuICBASW5wdXQoKVxuICBzaG93SVNPV2Vla051bWJlcnM6IGJvb2xlYW47XG4gIEBJbnB1dCgpXG4gIHNob3dEcm9wZG93bnM6IGJvb2xlYW47XG4gIEBJbnB1dCgpXG4gIGlzSW52YWxpZERhdGU6IEZ1bmN0aW9uO1xuICBASW5wdXQoKVxuICBpc0N1c3RvbURhdGU6IEZ1bmN0aW9uO1xuICBASW5wdXQoKVxuICBpc1Rvb2x0aXBEYXRlOiBGdW5jdGlvbjtcbiAgQElucHV0KClcbiAgc2hvd0NsZWFyQnV0dG9uOiBib29sZWFuO1xuICBASW5wdXQoKVxuICBjdXN0b21SYW5nZURpcmVjdGlvbjogYm9vbGVhbjtcbiAgQElucHV0KClcbiAgcmFuZ2VzOiBhbnk7XG4gIEBJbnB1dCgpXG4gIG9wZW5zOiBzdHJpbmc7XG4gIEBJbnB1dCgpXG4gIGRyb3BzOiBzdHJpbmc7XG4gIGZpcnN0TW9udGhEYXlDbGFzczogc3RyaW5nO1xuICBASW5wdXQoKVxuICBsYXN0TW9udGhEYXlDbGFzczogc3RyaW5nO1xuICBASW5wdXQoKVxuICBlbXB0eVdlZWtSb3dDbGFzczogc3RyaW5nO1xuICBASW5wdXQoKVxuICBlbXB0eVdlZWtDb2x1bW5DbGFzczogc3RyaW5nO1xuICBASW5wdXQoKVxuICBmaXJzdERheU9mTmV4dE1vbnRoQ2xhc3M6IHN0cmluZztcbiAgQElucHV0KClcbiAgbGFzdERheU9mUHJldmlvdXNNb250aENsYXNzOiBzdHJpbmc7XG4gIEBJbnB1dCgpXG4gIGtlZXBDYWxlbmRhck9wZW5pbmdXaXRoUmFuZ2U6IGJvb2xlYW47XG4gIEBJbnB1dCgpXG4gIHNob3dSYW5nZUxhYmVsT25JbnB1dDogYm9vbGVhbjtcbiAgQElucHV0KClcbiAgc2hvd0NhbmNlbDogYm9vbGVhbiA9IGZhbHNlO1xuICBASW5wdXQoKVxuICBsb2NrU3RhcnREYXRlOiBib29sZWFuID0gZmFsc2U7XG4gIC8vIHRpbWVwaWNrZXIgdmFyaWFibGVzXG4gIEBJbnB1dCgpXG4gIHRpbWVQaWNrZXI6IEJvb2xlYW4gPSBmYWxzZTtcbiAgQElucHV0KClcbiAgdGltZVBpY2tlcjI0SG91cjogQm9vbGVhbiA9IGZhbHNlO1xuICBASW5wdXQoKVxuICB0aW1lUGlja2VySW5jcmVtZW50OiBudW1iZXIgPSAxO1xuICBASW5wdXQoKVxuICB0aW1lUGlja2VyU2Vjb25kczogQm9vbGVhbiA9IGZhbHNlO1xuICBASW5wdXQoKSBjbG9zZU9uQXV0b0FwcGx5ID0gdHJ1ZTtcbiAgX2xvY2FsZTogTG9jYWxlQ29uZmlnID0ge307XG4gIEBJbnB1dCgpIHNldCBsb2NhbGUodmFsdWUpIHtcbiAgICB0aGlzLl9sb2NhbGUgPSB7Li4udGhpcy5fbG9jYWxlU2VydmljZS5jb25maWcsIC4uLnZhbHVlfTtcbiAgfVxuICBnZXQgbG9jYWxlKCk6IGFueSB7XG4gICAgcmV0dXJuIHRoaXMuX2xvY2FsZTtcbiAgfVxuICBASW5wdXQoKVxuICBwcml2YXRlIF9lbmRLZXk6IHN0cmluZyA9ICdlbmREYXRlJztcbiAgcHJpdmF0ZSBfc3RhcnRLZXk6IHN0cmluZyA9ICdzdGFydERhdGUnO1xuICBASW5wdXQoKSBzZXQgc3RhcnRLZXkodmFsdWUpIHtcbiAgICBpZiAodmFsdWUgIT09IG51bGwpIHtcbiAgICAgIHRoaXMuX3N0YXJ0S2V5ID0gdmFsdWU7XG4gICAgfSBlbHNlIHtcbiAgICAgIHRoaXMuX3N0YXJ0S2V5ID0gJ3N0YXJ0RGF0ZSc7XG4gICAgfVxuICB9XG4gIEBJbnB1dCgpIHNldCBlbmRLZXkodmFsdWUpIHtcbiAgICBpZiAodmFsdWUgIT09IG51bGwpIHtcbiAgICAgIHRoaXMuX2VuZEtleSA9IHZhbHVlO1xuICAgIH0gZWxzZSB7XG4gICAgICB0aGlzLl9lbmRLZXkgPSAnZW5kRGF0ZSc7XG4gICAgfVxuICB9XG4gIG5vdEZvckNoYW5nZXNQcm9wZXJ0eTogQXJyYXk8c3RyaW5nPiA9IFtcbiAgICAnbG9jYWxlJyxcbiAgICAnZW5kS2V5JyxcbiAgICAnc3RhcnRLZXknXG4gIF07XG5cbiAgZ2V0IHZhbHVlKCkge1xuICAgIHJldHVybiB0aGlzLl92YWx1ZSB8fCBudWxsO1xuICB9XG4gIHNldCB2YWx1ZSh2YWwpIHtcbiAgICB0aGlzLl92YWx1ZSA9IHZhbDtcbiAgICB0aGlzLl9vbkNoYW5nZSh2YWwpO1xuICAgIHRoaXMuX2NoYW5nZURldGVjdG9yUmVmLm1hcmtGb3JDaGVjaygpO1xuICB9XG4gIEBPdXRwdXQoJ2NoYW5nZScpIG9uQ2hhbmdlOiBFdmVudEVtaXR0ZXI8T2JqZWN0PiA9IG5ldyBFdmVudEVtaXR0ZXIoKTtcbiAgQE91dHB1dCgncmFuZ2VDbGlja2VkJykgcmFuZ2VDbGlja2VkOiBFdmVudEVtaXR0ZXI8T2JqZWN0PiA9IG5ldyBFdmVudEVtaXR0ZXIoKTtcbiAgQE91dHB1dCgnZGF0ZXNVcGRhdGVkJykgZGF0ZXNVcGRhdGVkOiBFdmVudEVtaXR0ZXI8T2JqZWN0PiA9IG5ldyBFdmVudEVtaXR0ZXIoKTtcbiAgQE91dHB1dCgpIHN0YXJ0RGF0ZUNoYW5nZWQ6IEV2ZW50RW1pdHRlcjxPYmplY3Q+ID0gbmV3IEV2ZW50RW1pdHRlcigpO1xuICBAT3V0cHV0KCkgZW5kRGF0ZUNoYW5nZWQ6IEV2ZW50RW1pdHRlcjxPYmplY3Q+ID0gbmV3IEV2ZW50RW1pdHRlcigpO1xuICBASG9zdEJpbmRpbmcoJ2Rpc2FibGVkJykgZ2V0IGRpc2FibGVkKCkgeyByZXR1cm4gdGhpcy5fZGlzYWJsZWQ7IH1cbiAgY29uc3RydWN0b3IoXG4gICAgcHVibGljIHZpZXdDb250YWluZXJSZWY6IFZpZXdDb250YWluZXJSZWYsXG4gICAgcHVibGljIF9jaGFuZ2VEZXRlY3RvclJlZjogQ2hhbmdlRGV0ZWN0b3JSZWYsXG4gICAgcHJpdmF0ZSBfY29tcG9uZW50RmFjdG9yeVJlc29sdmVyOiBDb21wb25lbnRGYWN0b3J5UmVzb2x2ZXIsXG4gICAgcHJpdmF0ZSBfZWw6IEVsZW1lbnRSZWYsXG4gICAgcHJpdmF0ZSBfcmVuZGVyZXI6IFJlbmRlcmVyMixcbiAgICBwcml2YXRlIGRpZmZlcnM6IEtleVZhbHVlRGlmZmVycyxcbiAgICBwcml2YXRlIF9sb2NhbGVTZXJ2aWNlOiBMb2NhbGVTZXJ2aWNlLFxuICAgIHByaXZhdGUgZWxlbWVudFJlZjogRWxlbWVudFJlZlxuICApIHtcbiAgICB0aGlzLmRyb3BzID0gJ2Rvd24nO1xuICAgIHRoaXMub3BlbnMgPSAnYXV0byc7XG4gICAgY29uc3QgY29tcG9uZW50RmFjdG9yeSA9IHRoaXMuX2NvbXBvbmVudEZhY3RvcnlSZXNvbHZlci5yZXNvbHZlQ29tcG9uZW50RmFjdG9yeShEYXRlcmFuZ2VwaWNrZXJDb21wb25lbnQpO1xuICAgIHZpZXdDb250YWluZXJSZWYuY2xlYXIoKTtcbiAgICBjb25zdCBjb21wb25lbnRSZWYgPSB2aWV3Q29udGFpbmVyUmVmLmNyZWF0ZUNvbXBvbmVudChjb21wb25lbnRGYWN0b3J5KTtcbiAgICB0aGlzLnBpY2tlciA9ICg8RGF0ZXJhbmdlcGlja2VyQ29tcG9uZW50PmNvbXBvbmVudFJlZi5pbnN0YW5jZSk7XG4gICAgdGhpcy5waWNrZXIuaW5saW5lID0gZmFsc2U7IC8vIHNldCBpbmxpbmUgdG8gZmFsc2UgZm9yIGFsbCBkaXJlY3RpdmUgdXNhZ2VcbiAgfVxuICBuZ09uSW5pdCgpIHtcbiAgICB0aGlzLnBpY2tlci5zdGFydERhdGVDaGFuZ2VkLmFzT2JzZXJ2YWJsZSgpLnN1YnNjcmliZSgoaXRlbUNoYW5nZWQ6IGFueSkgPT4ge1xuICAgICAgdGhpcy5zdGFydERhdGVDaGFuZ2VkLmVtaXQoaXRlbUNoYW5nZWQpO1xuICAgIH0pO1xuICAgIHRoaXMucGlja2VyLmVuZERhdGVDaGFuZ2VkLmFzT2JzZXJ2YWJsZSgpLnN1YnNjcmliZSgoaXRlbUNoYW5nZWQ6IGFueSkgPT4ge1xuICAgICAgdGhpcy5lbmREYXRlQ2hhbmdlZC5lbWl0KGl0ZW1DaGFuZ2VkKTtcbiAgICB9KTtcbiAgICB0aGlzLnBpY2tlci5yYW5nZUNsaWNrZWQuYXNPYnNlcnZhYmxlKCkuc3Vic2NyaWJlKChyYW5nZTogYW55KSA9PiB7XG4gICAgICB0aGlzLnJhbmdlQ2xpY2tlZC5lbWl0KHJhbmdlKTtcbiAgICB9KTtcbiAgICB0aGlzLnBpY2tlci5kYXRlc1VwZGF0ZWQuYXNPYnNlcnZhYmxlKCkuc3Vic2NyaWJlKChyYW5nZTogYW55KSA9PiB7XG4gICAgICB0aGlzLmRhdGVzVXBkYXRlZC5lbWl0KHJhbmdlKTtcbiAgICB9KTtcbiAgICB0aGlzLnBpY2tlci5jaG9vc2VkRGF0ZS5hc09ic2VydmFibGUoKS5zdWJzY3JpYmUoKGNoYW5nZTogYW55KSA9PiB7XG4gICAgICBpZiAoY2hhbmdlKSB7XG4gICAgICAgIGNvbnN0IHZhbHVlID0ge307XG4gICAgICAgIHZhbHVlW3RoaXMuX3N0YXJ0S2V5XSA9IGNoYW5nZS5zdGFydERhdGU7XG4gICAgICAgIHZhbHVlW3RoaXMuX2VuZEtleV0gPSBjaGFuZ2UuZW5kRGF0ZTtcbiAgICAgICAgdGhpcy52YWx1ZSA9IHZhbHVlO1xuICAgICAgICB0aGlzLm9uQ2hhbmdlLmVtaXQodmFsdWUpO1xuICAgICAgICBpZiAodHlwZW9mIGNoYW5nZS5jaG9zZW5MYWJlbCA9PT0gJ3N0cmluZycpIHtcbiAgICAgICAgICB0aGlzLl9lbC5uYXRpdmVFbGVtZW50LnZhbHVlID0gY2hhbmdlLmNob3NlbkxhYmVsO1xuICAgICAgICB9XG4gICAgICB9XG4gICAgfSk7XG4gICAgdGhpcy5waWNrZXIuZmlyc3RNb250aERheUNsYXNzID0gdGhpcy5maXJzdE1vbnRoRGF5Q2xhc3M7XG4gICAgdGhpcy5waWNrZXIubGFzdE1vbnRoRGF5Q2xhc3MgPSB0aGlzLmxhc3RNb250aERheUNsYXNzO1xuICAgIHRoaXMucGlja2VyLmVtcHR5V2Vla1Jvd0NsYXNzID0gdGhpcy5lbXB0eVdlZWtSb3dDbGFzcztcbiAgICB0aGlzLnBpY2tlci5lbXB0eVdlZWtDb2x1bW5DbGFzcyA9IHRoaXMuZW1wdHlXZWVrQ29sdW1uQ2xhc3M7XG4gICAgdGhpcy5waWNrZXIuZmlyc3REYXlPZk5leHRNb250aENsYXNzID0gdGhpcy5maXJzdERheU9mTmV4dE1vbnRoQ2xhc3M7XG4gICAgdGhpcy5waWNrZXIubGFzdERheU9mUHJldmlvdXNNb250aENsYXNzID0gdGhpcy5sYXN0RGF5T2ZQcmV2aW91c01vbnRoQ2xhc3M7XG4gICAgdGhpcy5waWNrZXIuZHJvcHMgPSB0aGlzLmRyb3BzO1xuICAgIHRoaXMucGlja2VyLm9wZW5zID0gdGhpcy5vcGVucztcbiAgICB0aGlzLmxvY2FsZURpZmZlciA9IHRoaXMuZGlmZmVycy5maW5kKHRoaXMubG9jYWxlKS5jcmVhdGUoKTtcbiAgICB0aGlzLnBpY2tlci5jbG9zZU9uQXV0b0FwcGx5ID0gdGhpcy5jbG9zZU9uQXV0b0FwcGx5O1xuICB9XG5cbiAgbmdPbkNoYW5nZXMoY2hhbmdlczogU2ltcGxlQ2hhbmdlcyk6IHZvaWQgIHtcbiAgICBmb3IgKGNvbnN0IGNoYW5nZSBpbiBjaGFuZ2VzKSB7XG4gICAgICBpZiAoY2hhbmdlcy5oYXNPd25Qcm9wZXJ0eShjaGFuZ2UpKSB7XG4gICAgICAgIGlmICh0aGlzLm5vdEZvckNoYW5nZXNQcm9wZXJ0eS5pbmRleE9mKGNoYW5nZSkgPT09IC0xKSB7XG4gICAgICAgICAgdGhpcy5waWNrZXJbY2hhbmdlXSA9IGNoYW5nZXNbY2hhbmdlXS5jdXJyZW50VmFsdWU7XG4gICAgICAgIH1cbiAgICAgIH1cbiAgICB9XG4gIH1cblxuICBuZ0RvQ2hlY2soKSB7XG4gICAgaWYgKHRoaXMubG9jYWxlRGlmZmVyKSB7XG4gICAgICBjb25zdCBjaGFuZ2VzID0gdGhpcy5sb2NhbGVEaWZmZXIuZGlmZih0aGlzLmxvY2FsZSk7XG4gICAgICBpZiAoY2hhbmdlcykge1xuICAgICAgICB0aGlzLnBpY2tlci51cGRhdGVMb2NhbGUodGhpcy5sb2NhbGUpO1xuICAgICAgfVxuICAgIH1cbiAgfVxuXG4gIG9uQmx1cigpIHtcbiAgICB0aGlzLl9vblRvdWNoZWQoKTtcbiAgfVxuXG4gIG9wZW4oZXZlbnQ/OiBhbnkpIHtcbiAgICBpZiAodGhpcy5kaXNhYmxlZCkge1xuICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICB0aGlzLnBpY2tlci5zaG93KGV2ZW50KTtcbiAgICBzZXRUaW1lb3V0KCgpID0+IHtcbiAgICAgIHRoaXMuc2V0UG9zaXRpb24oKTtcbiAgICB9KTtcbiAgfVxuXG4gIGhpZGUoZT8pIHtcbiAgICB0aGlzLnBpY2tlci5oaWRlKGUpO1xuICB9XG4gIHRvZ2dsZShlPykge1xuICAgIGlmICh0aGlzLnBpY2tlci5pc1Nob3duKSB7XG4gICAgICB0aGlzLmhpZGUoZSk7XG4gICAgfSBlbHNlIHtcbiAgICAgIHRoaXMub3BlbihlKTtcbiAgICB9XG4gIH1cblxuICBjbGVhcigpIHtcbiAgICB0aGlzLnBpY2tlci5jbGVhcigpO1xuICB9XG5cbiAgd3JpdGVWYWx1ZSh2YWx1ZSkge1xuICAgIHRoaXMuc2V0VmFsdWUodmFsdWUpO1xuICB9XG4gIHJlZ2lzdGVyT25DaGFuZ2UoZm4pIHtcbiAgICB0aGlzLl9vbkNoYW5nZSA9IGZuO1xuICB9XG4gIHJlZ2lzdGVyT25Ub3VjaGVkKGZuKSB7XG4gICAgdGhpcy5fb25Ub3VjaGVkID0gZm47XG4gIH1cbiAgc2V0RGlzYWJsZWRTdGF0ZShzdGF0ZTogYm9vbGVhbik6IHZvaWQge1xuICAgIHRoaXMuX2Rpc2FibGVkID0gc3RhdGU7XG59XG4gIHByaXZhdGUgc2V0VmFsdWUodmFsOiBhbnkpIHtcbiAgICBpZiAodmFsKSB7XG4gICAgICB0aGlzLnZhbHVlID0gdmFsO1xuICAgICAgaWYgKHZhbFt0aGlzLl9zdGFydEtleV0pIHtcbiAgICAgICAgdGhpcy5waWNrZXIuc2V0U3RhcnREYXRlKHZhbFt0aGlzLl9zdGFydEtleV0pO1xuICAgICAgfVxuICAgICAgaWYgKHZhbFt0aGlzLl9lbmRLZXldKSB7XG4gICAgICAgIHRoaXMucGlja2VyLnNldEVuZERhdGUodmFsW3RoaXMuX2VuZEtleV0pO1xuICAgICAgfVxuICAgICAgdGhpcy5waWNrZXIuY2FsY3VsYXRlQ2hvc2VuTGFiZWwoKTtcbiAgICAgIGlmICh0aGlzLnBpY2tlci5jaG9zZW5MYWJlbCkge1xuICAgICAgICB0aGlzLl9lbC5uYXRpdmVFbGVtZW50LnZhbHVlID0gdGhpcy5waWNrZXIuY2hvc2VuTGFiZWw7XG4gICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgIHRoaXMucGlja2VyLmNsZWFyKCk7XG4gICAgfVxuICB9XG4gIC8qKlxuICAgKiBTZXQgcG9zaXRpb24gb2YgdGhlIGNhbGVuZGFyXG4gICAqL1xuICBzZXRQb3NpdGlvbigpIHtcbiAgICBsZXQgc3R5bGU7XG4gICAgbGV0IGNvbnRhaW5lclRvcDtcbiAgICBjb25zdCBjb250YWluZXIgPSB0aGlzLnBpY2tlci5waWNrZXJDb250YWluZXIubmF0aXZlRWxlbWVudDtcbiAgICBjb25zdCBlbGVtZW50ID0gdGhpcy5fZWwubmF0aXZlRWxlbWVudDtcbiAgICBpZiAodGhpcy5kcm9wcyAmJiB0aGlzLmRyb3BzID09PSAndXAnKSB7XG4gICAgICBjb250YWluZXJUb3AgPSAoZWxlbWVudC5vZmZzZXRUb3AgLSBjb250YWluZXIuY2xpZW50SGVpZ2h0KSArICdweCc7XG4gICAgfSBlbHNlIHtcbiAgICAgIGNvbnRhaW5lclRvcCA9ICdhdXRvJztcbiAgICB9XG4gICAgaWYgKHRoaXMub3BlbnMgPT09ICdsZWZ0Jykge1xuICAgICAgc3R5bGUgPSB7XG4gICAgICAgICAgdG9wOiBjb250YWluZXJUb3AsXG4gICAgICAgICAgbGVmdDogKGVsZW1lbnQub2Zmc2V0TGVmdCAtIGNvbnRhaW5lci5jbGllbnRXaWR0aCArIGVsZW1lbnQuY2xpZW50V2lkdGgpICsgJ3B4JyxcbiAgICAgICAgICByaWdodDogJ2F1dG8nXG4gICAgICB9O1xuICAgIH0gZWxzZSBpZiAodGhpcy5vcGVucyA9PT0gJ2NlbnRlcicpIHtcbiAgICAgICAgc3R5bGUgPSB7XG4gICAgICAgICAgdG9wOiBjb250YWluZXJUb3AsXG4gICAgICAgICAgbGVmdDogKGVsZW1lbnQub2Zmc2V0TGVmdCAgKyAgZWxlbWVudC5jbGllbnRXaWR0aCAvIDJcbiAgICAgICAgICAgICAgICAgIC0gY29udGFpbmVyLmNsaWVudFdpZHRoIC8gMikgKyAncHgnLFxuICAgICAgICAgIHJpZ2h0OiAnYXV0bydcbiAgICAgICAgfTtcbiAgICB9IGVsc2UgaWYgKHRoaXMub3BlbnMgPT09ICdyaWdodCcpIHtcbiAgICAgICAgc3R5bGUgPSB7XG4gICAgICAgICAgdG9wOiBjb250YWluZXJUb3AsXG4gICAgICAgICAgbGVmdDogZWxlbWVudC5vZmZzZXRMZWZ0ICArICdweCcsXG4gICAgICAgICAgcmlnaHQ6ICdhdXRvJ1xuICAgICAgICB9O1xuICAgIH0gZWxzZSB7XG4gICAgICBjb25zdCBwb3NpdGlvbiA9IGVsZW1lbnQub2Zmc2V0TGVmdCAgKyAgZWxlbWVudC5jbGllbnRXaWR0aCAvIDIgLSBjb250YWluZXIuY2xpZW50V2lkdGggLyAyO1xuICAgICAgaWYgKHBvc2l0aW9uIDwgMCkge1xuICAgICAgICBzdHlsZSA9IHtcbiAgICAgICAgICB0b3A6IGNvbnRhaW5lclRvcCxcbiAgICAgICAgICBsZWZ0OiBlbGVtZW50Lm9mZnNldExlZnQgKyAncHgnLFxuICAgICAgICAgIHJpZ2h0OiAnYXV0bydcbiAgICAgICAgfTtcbiAgICAgIH1cbiAgICAgIGVsc2Uge1xuICAgICAgICBzdHlsZSA9IHtcbiAgICAgICAgICAgIHRvcDogY29udGFpbmVyVG9wLFxuICAgICAgICAgICAgbGVmdDogcG9zaXRpb24gKyAncHgnLFxuICAgICAgICAgICAgcmlnaHQ6ICdhdXRvJ1xuICAgICAgICB9O1xuICAgICAgfVxuICAgIH1cbiAgICBpZiAoc3R5bGUpIHtcbiAgICAgIHRoaXMuX3JlbmRlcmVyLnNldFN0eWxlKGNvbnRhaW5lciwgJ3RvcCcsIHN0eWxlLnRvcCk7XG4gICAgICB0aGlzLl9yZW5kZXJlci5zZXRTdHlsZShjb250YWluZXIsICdsZWZ0Jywgc3R5bGUubGVmdCk7XG4gICAgICB0aGlzLl9yZW5kZXJlci5zZXRTdHlsZShjb250YWluZXIsICdyaWdodCcsIHN0eWxlLnJpZ2h0KTtcbiAgICB9XG4gIH1cbiAgaW5wdXRDaGFuZ2VkKGUpIHtcbiAgICBpZiAoZS50YXJnZXQudGFnTmFtZS50b0xvd2VyQ2FzZSgpICE9PSAnaW5wdXQnKSB7XG4gICAgICByZXR1cm47XG4gICAgfVxuICAgIGlmICghZS50YXJnZXQudmFsdWUubGVuZ3RoKSB7XG4gICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnN0IGRhdGVTdHJpbmcgPSBlLnRhcmdldC52YWx1ZS5zcGxpdCh0aGlzLnBpY2tlci5sb2NhbGUuc2VwYXJhdG9yKTtcbiAgICBsZXQgc3RhcnQgPSBudWxsLCBlbmQgPSBudWxsO1xuICAgIGlmIChkYXRlU3RyaW5nLmxlbmd0aCA9PT0gMikge1xuICAgICAgc3RhcnQgPSBtb21lbnQoZGF0ZVN0cmluZ1swXSwgdGhpcy5waWNrZXIubG9jYWxlLmZvcm1hdCk7XG4gICAgICBlbmQgPSBtb21lbnQoZGF0ZVN0cmluZ1sxXSwgdGhpcy5waWNrZXIubG9jYWxlLmZvcm1hdCk7XG4gICAgfVxuICAgIGlmICh0aGlzLnNpbmdsZURhdGVQaWNrZXIgfHwgc3RhcnQgPT09IG51bGwgfHwgZW5kID09PSBudWxsKSB7XG4gICAgICBzdGFydCA9IG1vbWVudChlLnRhcmdldC52YWx1ZSwgdGhpcy5waWNrZXIubG9jYWxlLmZvcm1hdCk7XG4gICAgICBlbmQgPSBzdGFydDtcbiAgICB9XG4gICAgaWYgKCFzdGFydC5pc1ZhbGlkKCkgfHwgIWVuZC5pc1ZhbGlkKCkpIHtcbiAgICAgIHJldHVybjtcbiAgICB9XG4gICAgdGhpcy5waWNrZXIuc2V0U3RhcnREYXRlKHN0YXJ0KTtcbiAgICB0aGlzLnBpY2tlci5zZXRFbmREYXRlKGVuZCk7XG4gICAgdGhpcy5waWNrZXIudXBkYXRlVmlldygpO1xuXG4gIH1cbiAgLyoqXG4gICAqIEZvciBjbGljayBvdXRzaWRlIG9mIHRoZSBjYWxlbmRhcidzIGNvbnRhaW5lclxuICAgKiBAcGFyYW0gZXZlbnQgZXZlbnQgb2JqZWN0XG4gICAqL1xuICBASG9zdExpc3RlbmVyKCdkb2N1bWVudDpjbGljaycsIFsnJGV2ZW50J10pXG4gIG91dHNpZGVDbGljayhldmVudCk6IHZvaWQge1xuICAgIGlmICghZXZlbnQudGFyZ2V0KSB7XG4gICAgICByZXR1cm47XG4gICAgfVxuXG4gICAgaWYgKGV2ZW50LnRhcmdldC5jbGFzc0xpc3QuY29udGFpbnMoJ25neC1kYXRlcmFuZ2VwaWNrZXItYWN0aW9uJykpIHtcbiAgICAgIHJldHVybjtcbiAgICB9XG5cbiAgICBpZiAoIXRoaXMuZWxlbWVudFJlZi5uYXRpdmVFbGVtZW50LmNvbnRhaW5zKGV2ZW50LnRhcmdldCkpIHtcbiAgICAgIHRoaXMuaGlkZSgpO1xuICAgIH1cbiAgfVxufVxuIl19