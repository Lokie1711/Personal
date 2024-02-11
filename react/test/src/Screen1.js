import React, { useState, useEffect } from 'react';

const Screen1 = ({ onNext }) => {
  const [tableName, setTableName] = useState('');
  const [uniqueColumn, setUniqueColumn] = useState('');
  const [columnName, setColumnName] = useState('');
  const [websiteToAdd, setWebsiteToAdd] = useState('');
  const [websites, setWebsites] = useState([]);

  const handleButtonClick = () => {
    let apiUrl = '';

    if (uniqueColumn && !tableName && !columnName) {
      apiUrl = `http://localhost:8989/test/getById/${uniqueColumn}`;
    } else if (!uniqueColumn && tableName && !columnName) {
      apiUrl = `http://localhost:8989/test/getAll`;
    } else if (columnName) {
      apiUrl = `http://localhost:8989/test/getByName/${columnName}`;
    } else {
      console.error('Invalid combination');
      return;
    }

    fetch(apiUrl, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then(data => {
        onNext(data);
      })
      .catch(error => console.error('Error fetching data:', error));
  };

  const handleAddWebsite = () => {
    fetch(`http://localhost:8989/test/status/${websiteToAdd}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then(data => {
        fetchWebsiteStatuses(); // Refresh the website statuses after adding a new website
      })
      .catch(error => console.error('Error adding website:', error));
  };

  const fetchWebsiteStatuses = () => {
    fetch('http://localhost:8989/test/fetchWebsites', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then(data => {
        setWebsites(data);
      })
      .catch(error => console.error('Error fetching websites:', error));
  };

  // Fetch the website statuses when the component mounts
  useEffect(() => {
    fetchWebsiteStatuses();
  }, []);

  return (
    <div>
      <input type="text" placeholder="Table Name" value={tableName} onChange={e => setTableName(e.target.value)} />
      <input type="text" placeholder="Unique Column (ID)" value={uniqueColumn} onChange={e => setUniqueColumn(e.target.value)} />
      <input type="text" placeholder="Column Name" value={columnName} onChange={e => setColumnName(e.target.value)} />

      {/* New field for adding websites */}
      <input type="text" placeholder="Website to Add" value={websiteToAdd} onChange={e => setWebsiteToAdd(e.target.value)} />
      {/* Button to trigger adding the website to the backend database */}
      <button onClick={handleAddWebsite}>Add Website</button>

      <button onClick={handleButtonClick}>Fetch Data</button>

      {/* Table to display websites and statuses */}
      <table>
        <thead>
          <tr>
            <th>Website</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {websites.map(website => (
            <tr key={website.id}>
              <td>{website.name}</td>
              <td>{website.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Screen1;
