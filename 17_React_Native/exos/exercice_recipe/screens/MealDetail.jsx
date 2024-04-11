import { FlatList, Image, Pressable, ScrollView, StyleSheet, Text, View } from 'react-native'
import React, { useContext, useEffect, useLayoutEffect, useState } from 'react'
import DetailItem from '../components/DetailItem'
import Icon from 'react-native-vector-icons/AntDesign'
import favoriteContext from '../context/favoriteContext'

const MealDetail = ({ navigation, route }) => {
  const meal = route.params.meal
  const {favoriteList, addToFavorite, removeFavorite} = useContext(favoriteContext)
  const currentFavorite = favoriteList.find((fav) => fav.id === meal.id);
  const handleFavorite = () => {
    if(currentFavorite?.isFavorite){
        removeFavorite(meal.id);
    }else{
        addToFavorite(meal)
    }
}
  useLayoutEffect(() => {
    const buttonFavorite = () => (
        <Pressable onPress={handleFavorite}>
          <Icon size={30} name={currentFavorite?.isFavorite ? 'heart' : 'hearto'} color={'red'}></Icon>
        </Pressable>
    )
    navigation.setOptions({ headerRight: buttonFavorite })
  });
  return (
    <ScrollView >
      <View style={styles.container}>


        <Image source={{ uri: meal.imageUrl }} style={styles.image} />
        <Text style={styles.textTitle}>{meal.title}</Text>
        <Text style={styles.text}>{meal.duration} {meal.complexity.toUpperCase()} {meal.affordability.toUpperCase()}</Text>
        <Text style={styles.textSubTitle}>
          Ingrédients
        </Text>
        <View>
          {meal.ingredients.map((item) => <DetailItem item={item} key={item} />)}
        </View>

        <Text style={styles.textSubTitle}>Steps</Text>
        <View>
          {meal.steps.map((item) => <DetailItem item={item} key={item}/>)}
        </View>
      </View>
    </ScrollView>
  )
}

export default MealDetail

const styles = StyleSheet.create({
  container:{
    alignItems: 'center'
  },
  image: {
    width: '100%',
    height: 400
  },
  text:{
    fontSize: 17,
    marginVertical: 3,
  },
  textTitle: {
    fontWeight: '900',
    fontSize: 30,
    marginVertical: 10
  },
  textSubTitle: {
    color: 'orange',
    fontSize: 25,
    fontWeight: '600',
    borderBottomWidth: 3,
    borderBottomColor: 'orange',
    textAlign: 'center',
    width: 300,
    marginVertical: 10
  }
})