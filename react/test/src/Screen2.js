// Screen 2 Component
import React, { useState } from 'react';

const Screen2 = ({ tableData, onUpdate }) => {
  const [userInputs, setUserInputs] = useState({});

  const handleUpdate = () => {
    // Handle logic to update the values in the table based on user inputs
    onUpdate(userInputs);
  };

  return (
    <div>
      <table>
        <thead>
          <tr>
            {tableData && tableData.columnNames.map((column, index) => (
              <th key={index}>{column}</th>
            ))}
            <th>User Input</th>
          </tr>
        </thead>
        <tbody>
          {tableData && tableData.values.map((row, index) => (
            <tr key={index}>
              {Object.values(row).map((value, i) => (
                <td key={i} style={{ background: tableData.highlightedColumns.includes(i) ? 'green' : 'orange' }}>
                  {value}
                </td>
              ))}
              <td>
                <input
                  type="text"
                  value={userInputs[row[tableData.uniqueColumn]] || ''}
                  onChange={(e) => setUserInputs({ ...userInputs, [row[tableData.uniqueColumn]]: e.target.value })}
                  placeholder="Enter value"
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <button onClick={handleUpdate}>Update</button>
    </div>
  );
};

export default Screen2;
