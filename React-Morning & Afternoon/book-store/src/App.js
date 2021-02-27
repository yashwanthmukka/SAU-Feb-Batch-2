import React, { Fragment } from 'react'
import Details from './components/Details'
import './App.css'
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import Home from './components/Home'

function App() {
  return (
        
    
    <Router>
 <Switch>
 <Route exact path= '/' component={Home}/>
 <Route exact path={`/details/:id`} component={Details}/>
 </Switch>

        
    </Router>
  )
}

export default App
