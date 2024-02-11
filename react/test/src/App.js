import React, { useState } from 'react';
import Screen1 from './Screen1';
import Screen2 from './Screen2';

const App = () => {
  const [fetchedData, setFetchedData] = useState(null);

  const handleScreen1Next = (data) => {
    setFetchedData(data);
  };

  return (
    <div>
      {!fetchedData && <Screen1 onNext={handleScreen1Next} />} {/* Show Screen1 if data is not yet fetched */}
      {fetchedData && <Screen2 data={fetchedData} onUpdate={updatedData => console.log(updatedData)} />} {/* Show Screen2 if data is fetched */}
    </div>
  );
};

export default App;
