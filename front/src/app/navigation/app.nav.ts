import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'
import { CategoryComponent } from '../category/category.component'
import { AddCategory } from '../category/addCategory.compoenet'
import {EditCategoryComponent} from'../category/editCategory.component'
const APP_ROUTE: Routes = [
{path :'' ,component:CategoryComponent},
{path:'addCategory',component:AddCategory},
{path:'editCategory/:id',component:EditCategoryComponent}
];
@NgModule({
    imports: [
        RouterModule.forRoot(
            APP_ROUTE,
        )
    ],
    exports: [
        RouterModule
    ],

})
export class AppRoutingModule { }
