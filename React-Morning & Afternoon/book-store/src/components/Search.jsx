import React from 'react'
import "./Search.css"
import data from '../data/data'

const searchHandler = (e)=>{
   // alert(e.target.value)
    const temp = [];
    for(let i = 0;i<data.length;++i){
        if(data[i].name.includes(e.target.value)){
            temp.push(data[i]);
        }
    }
    console.log(temp);
    return temp;
}
function Search({stores,setStores}) {
    return (
        <div style={{display:'flex',flexDirection:'row',alignItems:'center',justifyContent:'center',padding:20,width:'50%',marginLeft:'auto',marginRight:'auto'}}>
            <input className="search" onChange={(e)=>{
                const temp = searchHandler(e);
                setStores(temp);
            }} placeholder="Search stores"/>
            <button className="btn">Search</button>
        </div>
    )
}

export default Search
