import "../styles/List.scss"
import {Product} from "../models/Product";
import {useState} from "react";


export default function List({itemList, setItemList}:{itemList:Product[],setItemList:Function}) {


    const removeItem = (key:number) => {
        const newList = itemList.filter(itemObj => itemObj.key !== key)
        setItemList(newList)
    };



// Das gewünschte Feature. Button mit "Count" funktion.
    // Vielleicht doch mit Mapping?

    // interface Icount{
    //     count : 1
    // }
    //
    // const [itemCount, setItemCount] = useState(1
    //
    // )
    // const increaseCount = (key: number) => {
    //     const newList = [...itemList];
    //     newList[key].count++;
    //     setItemList(newList)
    //     console.log(newList)
    // }
    //
    // const decreaseCount = (key:number) => {
    //     const newList    = [...itemList];
    //     newList[key].count--;
    //     setItemList(newList)
    //     console.log(newList)
    // }
    return (
        <div>
            {itemList.map((itemObj) => {
                return <div key={itemObj.key} className="Item">
                    <p>{itemObj.name} Anzahl: {itemObj.count}</p>
                    <button onClick={() => removeItem(itemObj.key)}>Remove</button>
                    {/*<button onClick={() => increaseCount(itemObj.key)}>+</button>*/}
                    {/*<button onClick={() => decreaseCount(itemObj.key)}>-</button>*/}
                </div>
            })}
        </div>
    )
}