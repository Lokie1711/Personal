import React, { useState, useEffect } from 'react';

const Screen2 = ({ data }) => {
  const [editableData, setEditableData] = useState([]);
  const [city, setCity] = useState('');

  useEffect(() => {
    setEditableData(data);
  }, [data]);

  const handleUpdate = (index) => {
    const updatedData = [...editableData];
    const updatedValue = updatedData[index].value;
    const apiUrl = `http://localhost:8989/test/updateByCity/${city}`;
    const requestBody = {
      newValue: updatedValue
    };

    fetch(apiUrl, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(requestBody)
    })
      .then(response => response.json())
      .then(updatedData => {
        // Handle the updated data as needed
        console.log('Updated data:', updatedData);
        setEditableData(updatedData); // Update the state with the edited data
      })
      .catch(error => console.error('Error updating:', error));
  };

  const inputStyle = {
    color: 'orange',
  };

  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>Column Name</th>
            <th>Value</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {editableData.map((item, index) => (
            <tr key={index}>
              <td style={{ color: 'green' }}>{item.columnName}</td>
              <td>
                <input
                  type="text"
                  value={item.value}
                  onChange={(e) => {
                    const updatedData = [...editableData];
                    updatedData[index].value = e.target.value;
                    setEditableData(updatedData);
                  }}
                  style={inputStyle}
                />
              </td>
              <td>
                <button onClick={() => handleUpdate(index)}>Update</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <input type="text" value={city} onChange={e => setCity(e.target.value)} style={inputStyle} />
    </div>
  );
};

export default Screen2;
