import './App.scss';
import {ChangeEventHandler, FormEventHandler, useEffect, useState} from "react";
import Mainpage from "./pages/Mainpage";

function App() {
    // const STORAGE_KEY = 'itemList';
    // const [inputData, setInputData] = useState("")
    // const [itemList, setItemList] = useState("" || []);
    //
    //
    // const addItem = () => {
    //     if (inputData === "") {
    //         alert("Kein Leerer String erlaubt")
    //     } else {
    //         // @ts-ignore
    //         setItemList([...itemList, {name: inputData, count: 1, key: Date.now()}])
    //         setInputData("")
    //     }
    // }
    // const onChangeHandler: ChangeEventHandler<HTMLInputElement> = (event) => {
    //     setInputData(event.currentTarget.value)
    // }
    // const handleSubmit: FormEventHandler<HTMLFormElement> = (event) => {
    //     addItem();
    //     event.preventDefault();
    // }


    // useEffect(() => {
    //     localStorage.setItem(STORAGE_KEY, JSON.stringify(itemList))
    // }, [itemList]);

    return (
        <>
            <Mainpage/>
        </>

        // <div className="App">
        //
        //     {/*<BrowserRouter>*/}
        //     {/*    <Routes>*/}
        //     {/*        <Route path="/" element={< />}>*/}
        //     {/*            <Route path="" element={< />} />*/}
        //     {/*            <Route path="" element={</>} />*/}
        //     {/*        </Route>*/}
        //     {/*    </Routes>*/}
        //     {/*</BrowserRouter>*/}
        //
        //     <header className="header"> Grocery List</header>
        //     <div className="formButtonWrapper">
        //         <form className="form" onSubmit={handleSubmit}>
        //             <input placeholder="Add Item"
        //                    value={inputData}
        //                    onChange={onChangeHandler}
        //             />
        //         </form>
        //         <button className="button" onClick={addItem}>+</button>
        //     </div>
        //     <div className="listWrapper">
        //         <List itemList={itemList} setItemList={setItemList}/>
        //     </div>
        // </div>
    )
}

export default App;
