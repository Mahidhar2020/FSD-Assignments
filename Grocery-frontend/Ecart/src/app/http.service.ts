import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
data;
  constructor(private http:HttpClient) { }


  showcart()
  {
    const token=sessionStorage.getItem("token");
    const headers=new HttpHeaders({Authorization:'Basic '+token});
    return this.http.get("http://localhost:8090/cart/showcart/recieve/",{headers});
  }
  addProductToCart(productid:Number)
  {
    console.log(productid);
    const token=sessionStorage.getItem("token");
    const headers=new HttpHeaders({Authorization:'Basic '+token});
    return this.http.get("http://localhost:8090/cart/addtocart/recieve/"+productid, {headers});
  }
deleteproduct(productid:Number)
  {
    console.log(productid);
    const token=sessionStorage.getItem("token");
    const headers=new HttpHeaders({Authorization:'Basic '+token});
    return this.http.get("http://localhost:8090/cart/deleteproduct/recieve/"+productid, {headers});
  }
  clearCart(productid:Number)
  {
    console.log(productid);
    const token=sessionStorage.getItem("token");
    const headers=new HttpHeaders({Authorization:'Basic '+token});
    return this.http.get("http://localhost:8090/cart/removeproduct/recieve/"+productid, {headers});
  }

  checkout()
  {
    const token=sessionStorage.getItem("token");
    const headers=new HttpHeaders({Authorization:'Basic '+token});
    return this.http.get("http://localhost:8090/cart/checkout/recieve",{headers});
  }

  getinfo()
  {
    const token=sessionStorage.getItem("token");
    const headers=new HttpHeaders({Authorization:'Basic '+token});
    return this.http.get("http://localhost:8090/profile/get",{headers});
  }



  
  removeproductfromcart(productid:Number)
  {
    console.log(productid);
    const token=sessionStorage.getItem("token");
    const headers=new HttpHeaders({Authorization:'Basic '+token});
    return this.http.get("http://localhost:8090/cart/removeproduct/recieve/"+productid, {headers});
  }
  

  getHistoryOrder(){
    const token=sessionStorage.getItem("token");
    const headers=new HttpHeaders({Authorization:'Basic '+token});
    return this.http.get("http://localhost:8090/cart/checkout/orderhistory/recieve", {headers});
  }

  addProduct(product){
    const token=sessionStorage.getItem("token");
    const headers=new HttpHeaders({Authorization:'Basic '+token});
    return this.http.post("http://localhost:8090/api/addproducts",product,{headers}).subscribe(res=>{
    this.data=res;
    console.log(this.data);
    alert("product added");
  });
}
}
