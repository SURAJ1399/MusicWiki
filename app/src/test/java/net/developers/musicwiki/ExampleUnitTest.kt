package net.developers.musicwiki

import androidx.test.runner.AndroidJUnit4;


import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import net.developers.musicwiki.repo.globalRepo
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ExampleUnitTest

{
@get:Rule
val hiltRule=HiltAndroidRule(ExampleUnitTest::class.java)

@Inject
lateinit var globalRepo: globalRepo

@Before
fun init()= hiltRule.inject()


    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    suspend fun getTags()
    {
     globalRepo.getTag().body()!!.toptags.tag
    }
}