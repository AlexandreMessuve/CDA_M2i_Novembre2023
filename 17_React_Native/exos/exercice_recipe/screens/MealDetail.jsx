import { FlatList, Image, ScrollView, StyleSheet, Text, View } from 'react-native'
import React, { useLayoutEffect } from 'react'
import DetailItem from '../components/DetailItem'

const MealDetail = ({ navigation, route }) => {
  const meal = route.params.meal

  useLayoutEffect(() => {
    navigation.setOptions({ title: `${meal.title} Detail` })
  })
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