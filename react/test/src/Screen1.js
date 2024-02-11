// Screen 1 Component
import React, { useState } from 'react';
import { Link } from 'react-router-dom';


const Screen1 = ({ onFetchData }) => {
  const [tableName, setTableName] = useState('');
  const [uniqueColumn, setUniqueColumn] = useState('');
  const [columnName, setColumnName] = useState('');

  const handleNextScreen = () => {
    // Add validation for table name, unique column, and column name
    onFetchData(tableName, uniqueColumn, columnName);
  };

  return (
    <div>
      <div>
        <label>Table Name</label>
        <input type="text" value={tableName} onChange={(e) => setTableName(e.target.value)} />
      </div>
      <div>
        <label>Unique Column</label>
        <input type="text" value={uniqueColumn} onChange={(e) => setUniqueColumn(e.target.value)} />
      </div>
      <div>
        <label>Column Name</label>
        <input type="text" value={columnName} onChange={(e) => setColumnName(e.target.value)} />
      </div>
      <Link to="/screen2"><button>Go to Screen 2</button></Link>
    </div>
  );
};

export default Screen1;
