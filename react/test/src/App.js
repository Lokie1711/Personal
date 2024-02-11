// App.js

import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Screen1 from './Screen1';
import Screen2 from './Screen2';

function fetchData(tableName, uniqueColumn, columnName) {
  // Implement the logic to fetch data based on the input parameters
  // For example, make an API call or fetch data from a source
  // You can also include the logic for routing to the next screen here
}

function App() {
  return (
    <Router>
      <Routes>
        <Route 
          path="/" 
          element={<Screen1 onFetchData={fetchData} />}   // Pass the fetchData function as a prop
        />
        <Route path="/screen2" element={<Screen2 />} />
      </Routes>
    </Router>
  );
}

export default App;
