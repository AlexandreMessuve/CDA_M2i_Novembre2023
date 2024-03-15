import { Image, ImageBackground, Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'

const MealCard = ({ meal, navigation }) => {
    return (
        <View style={styles.container}>
            <Pressable onPress={() => navigation.navigate('MealDetail', {meal: meal})}>
                <ImageBackground source={{ uri: meal.imageUrl }} style={styles.img} alt={meal.title} />
                <View style={styles.textView}>
                    <Text style={styles.textTitle}>{meal.title}</Text>
                    <Text style={styles.text}>{meal.duration} {meal.complexity.toUpperCase()} {meal.affordability.toUpperCase()}</Text>
                </View>
            </Pressable>
        </View>

    )
}

export default MealCard

const styles = StyleSheet.create({
    container: {
        elevation: 10,
        shadowColor: 'black',
        borderWidth: 1,
        borderRadius: 20,
        borderColor: 'grey',
        width: 400,
        marginVertical: 30,
        overflow: 'hidden',
    },
    img: {
        width: 400,
        height: 200
    },
    textView: {
        width: 400,
        alignItems: 'center',
        backgroundColor: 'white'
    },
    textTitle: {
        marginTop: 10,
        fontSize: 18,
        fontWeight: '800'
    },
    text: {
        marginVertical: 10
    }
})