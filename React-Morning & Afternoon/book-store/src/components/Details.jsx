import React from 'react'
import { useParams } from 'react-router-dom'
import './Details.css'
import data from '../data/data'

function Details() {
    let {id} = useParams();
    let imageUrl = data[id].img;
    let title = data[id].name;
    let price  = data[id].price;
    let desc = data[id].desc;
    return (
        <div className="details">
            <img className="details-image" src={imageUrl} alt="img"/>
            <div className="details-body">
                <h1 className="title">{title}</h1>
                <p className = "price">Rs.{price}</p>
                <p className="description">{desc}</p>
            </div>
        </div>
        
    )
}

export default Details
