import React, { useState } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import Categories from './screens/Categories';
import Meals from './screens/Meals';
import MealDetail from './screens/MealDetail';
import FavoriteContext from './context/favoriteContext';
const Stack = createNativeStackNavigator();

const App = () => {
  const [favoriteList, setFavoriteList] = useState([])
  const addToFavorite = (meal) => {
    if (favoriteList.find((favorite) => favorite.id === meal.id)) {
      return;
    }
    const newFavorite = {...meal, isFavorite: true}
    setFavoriteList([...favoriteList, newFavorite])
  }
  const removeFavorite = (id) => {
    const newFavoriteList = favoriteList.filter((favorite) => favorite.id !== id);
    setFavoriteList(newFavoriteList);
  }
  return (
    <NavigationContainer>
      <FavoriteContext.Provider value={{
        favoriteList,
        addToFavorite,
        removeFavorite
      }}>

        <Stack.Navigator initialRouteName="Categories">
          <Stack.Screen
            name="Categories"
            component={Categories}
            options={{ title: 'All Categories' }}
          />
          <Stack.Screen
            name="Meals"
            component={Meals}
            options={{ title: 'Meals Overview' }}
          />
          <Stack.Screen 
            name="MealDetail" 
            component={MealDetail} 
            options={{ title: 'About the detail' }}
          />
        </Stack.Navigator>
      </FavoriteContext.Provider>
    </NavigationContainer>
  );
};

export default App;
