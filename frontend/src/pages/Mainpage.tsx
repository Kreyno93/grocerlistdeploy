import Header from "../components/Header";
import List from "../components/List";
import Login from "../components/Login";

export default function Mainpage(itemList:any,setItemList:any){
    return(
        <div className="mainPage">
            <Header/>
            <Login/>
            <List/>
        </div>
    )
}