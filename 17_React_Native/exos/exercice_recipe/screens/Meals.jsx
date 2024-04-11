import { FlatList, StyleSheet } from 'react-native'
import React from 'react'
import { MEALS } from '../data/data';
import MealCard from '../components/MealCard';

const Meals = ({navigation, route}) => {
    const categorie = route.params.categorie;
    console.log(categorie)
    const meals = MEALS.filter((meal) => meal.categoryIds.find((cat) => cat === categorie.id) === categorie.id);
  return (
            <FlatList
                contentContainerStyle={styles.container}
                showsHorizontalScrollIndicator={false}
                showsVerticalScrollIndicator={false}
                data={meals}
                renderItem={({ item }) => {
                    return (
                        <MealCard navigation={navigation} meal={item} />
                    )
                }}
            />
  )
}

export default Meals

const styles = StyleSheet.create({
    container: {
        flexGrow: 1,
        justifyContent: 'center',
        alignItems: 'center'
    }
})