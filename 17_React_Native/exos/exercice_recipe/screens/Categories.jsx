import { FlatList, Pressable, StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import { CATEGORIES } from '../data/data'
const Categories = ({ navigation }) => {
    useEffect(() => {
        console.log(CATEGORIES);
    })
    return (
        <FlatList
            data={CATEGORIES}
            renderItem={({ item }) => {
                const styles = StyleSheet.create({
                    container: {
                            backgroundColor: item.color,
                            width: 180,
                            height: 180,
                            alignItems: 'center',
                            justifyContent: 'center',
                            margin: 20,
                            shadowColor: 'black',
                            elevation: 5,
                            borderRadius: 10,
                            
                        },
                    text: {
                        color: 'black',
                        fontSize: 20,
                        fontWeight: 'bold'
                    }
                })
                return (
                    <Pressable  style={styles.container} 
                                onPress={() => navigation.navigate('Meals', {categorie: item})}
                    >
                            <Text style={styles.text}>
                                {item.title}
                            </Text>
                    </Pressable>
                )
            }}
            keyExtractor={(item) => item.id}
            numColumns={2}
        />
    )
}

export default Categories