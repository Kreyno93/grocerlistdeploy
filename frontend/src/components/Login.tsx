import {ChangeEventHandler, FormEventHandler, useState} from "react";
import "../styles/Login.scss"
export default function Login(){

    const [LoginData, setLoginData] = useState("")

    const onChangeHandler: ChangeEventHandler<HTMLInputElement> = (event) => {
        setLoginData(event.currentTarget.value)
    }
    const handleSubmit: FormEventHandler<HTMLFormElement> = (event) => {
        event.preventDefault();
    }
return(
    <div className="LoginPage">
        <form className="LoginForm" onSubmit={handleSubmit}>
            <input placeholder="Username"
                   value={LoginData}
                   onChange={onChangeHandler}/>
        </form>
        <button className="LoginButton" >Login</button>
    </div>
)
}