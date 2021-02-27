import React from 'react'
import './Card.css'

function Card({imageUrl,author,price,title}) {
    return (
        <div className="card">
            <img className="card-image" src={imageUrl} alt="store" />
            <div className="card-body">
                <h1 className="card-title">{title}</h1>
                <h1 className="card-title"> Rs. {price}</h1>
                <p className="card-author">{author}</p>
                
            </div>
            
        </div>
    )
}

export default Card
