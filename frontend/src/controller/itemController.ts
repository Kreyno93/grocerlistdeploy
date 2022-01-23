import {useState} from "react";

export default function ItemController(inputData:any,setInputData:any) {
    const [itemList, setItemList] = useState("" || []);


    const addItem = () => {
        if (inputData === "") {
            alert("Kein Leerer String erlaubt")
        } else {
            // @ts-ignore
            setItemList([...itemList, {name: inputData, count: 1, key: Date.now()}])
            setInputData("")
        }
    }
}